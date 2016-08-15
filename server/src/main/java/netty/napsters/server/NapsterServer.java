package netty.napsters.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class NapsterServer {

	private int port;
	private EventLoopGroup boss = null;
	private EventLoopGroup worker = null;

	public NapsterServer(int port) {
		this.port = port;
	}

	public void run() {
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

}

class NapsterServerChildHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {
		arg0.pipeline().addLast(new StringDecoder());
		arg0.pipeline().addLast(new ServerHandler());
	}
}