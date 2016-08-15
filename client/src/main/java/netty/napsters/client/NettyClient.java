package netty.napsters.client;

import java.nio.charset.Charset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

public class NettyClient {
	private EventLoopGroup worker = null;
	private Bootstrap clientBoot = null;
	private String ipAddress;
	private Channel channel = null;
	private NettyClientHandlerInterface nettyClientHandler;
	private static final Logger LOGGER = LogManager.getLogger(NettyClient.class);

	public NettyClient(NettyClientHandlerInterface nettyClientHandler) {
		this.nettyClientHandler = nettyClientHandler;
	}

	public NettyClientHandlerInterface getHandler() {
		return nettyClientHandler;
	}

	public void connect(String ipAddress, String nickName) {

		this.ipAddress = ipAddress;
		worker = new NioEventLoopGroup();
		clientBoot = new Bootstrap();
		clientBoot.group(worker);
		clientBoot.channel(NioSocketChannel.class);
		clientBoot.handler(new clientHandler());
		try {
			channel = clientBoot.connect(this.ipAddress, 7878).sync().channel();
			String Message = "CONNECT " + nickName;
			channel.writeAndFlush(Unpooled.copiedBuffer(Message.getBytes())).sync();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fileClientconnect(String ipAddress, String checksum, String filePath) {

		this.ipAddress = ipAddress;
		worker = new NioEventLoopGroup();
		clientBoot = new Bootstrap();
		clientBoot.group(worker);
		clientBoot.channel(NioSocketChannel.class);
		clientBoot.handler(new clientHandler());
		try {
			channel = clientBoot.connect(this.ipAddress, 7777).sync().channel();
			String Message = "GET " + checksum;
			channel.writeAndFlush(Unpooled.copiedBuffer(Message.getBytes())).sync();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String Message) {
		try {

			channel.writeAndFlush(Unpooled.copiedBuffer(Message.getBytes())).sync();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendCommond(String Commond) {
		sendMessage(Commond);
	}

	/**
	 * Close socket for client.
	 */
	public void disconnect() {
		// Say goodbye to Napster server
		sendCommond("QUIT");

		worker.shutdownGracefully();

		LOGGER.info("Disconnected from server.");
	}
	
	class clientHandler extends ChannelInitializer<SocketChannel> {

		@Override
		protected void initChannel(SocketChannel arg0) throws Exception {
			// TODO Auto-generated method stub
			
			
			
			arg0.pipeline().addLast("chunkedWriter", new ChunkedWriteHandler());
			arg0.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
			arg0.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
			
			arg0.pipeline().addLast(new NettyClientHandler());
			

		}
	}
	 class NettyClientHandler extends SimpleChannelInboundHandler<Object> {
			

			@Override
			protected void channelRead0(ChannelHandlerContext arg0, Object arg1) throws Exception {
				// TODO Auto-generated method stub
				String message = (String) arg1;
				System.out.println(nettyClientHandler.getName());
				nettyClientHandler.messageHandler(message, ApplicationBootstrap.response);

			}

			@Override
			public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

				// ctx.close();

			}
		}
}

