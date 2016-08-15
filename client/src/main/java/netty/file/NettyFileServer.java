package netty.file;

import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Map;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

public class NettyFileServer {
	private EventLoopGroup boss = null;
	private EventLoopGroup worker = null;
	private static NettyFileServer instance = new NettyFileServer();
	public static Map<String, String> sharedFiles = new Hashtable<>();

	public static NettyFileServer getInstance() {
		return instance;
	}

	private NettyFileServer() {

	}

	public void run(int port) {
		boss = new NioEventLoopGroup();
		worker = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(boss, worker);
		bootstrap.channel(NioServerSocketChannel.class);
		bootstrap.childHandler(new NapsterServerChildHandler());
		try {
			bootstrap.bind(port).sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	public void stopServer() {

		boss.shutdownGracefully();
		worker.shutdownGracefully();

	}

	/**
	 * Register new file to the file server for sharing.
	 *
	 * @param checksum
	 *            the checksum of the file
	 * @param filePath
	 *            the absolute path of the file
	 */
	public void shareNewFile(String checksum, String filePath) {
		sharedFiles.put(checksum, filePath);
	}

	/**
	 * Remove a shared file from the file server because it is no longer shared.
	 * 
	 * @param checksum
	 *            the checksum of the file
	 */
	public void unshareFile(String checksum) {
		sharedFiles.remove(checksum);
	}

	/**
	 * Check if the shared file requested is available.
	 * 
	 * @param checksum
	 *            - the checksum of the file
	 * @return whether the shared file is available
	 */
	public boolean contains(String checksum) {
		return sharedFiles.containsKey(checksum);
	}
}

class NapsterServerChildHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {

		arg0.pipeline().addLast("chunkedWriter", new ChunkedWriteHandler());
		arg0.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
		// 解码格式
		arg0.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
		arg0.pipeline().addLast(new NettyFileServerHandler());

	}
}
