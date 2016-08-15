/*package netty.napsters.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyClientHandler extends SimpleChannelInboundHandler<Object> {
	private static Response response = ApplicationBootstrap.response;

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		String message = (String) arg1;
		
		ApplicationBootstrap.nettyClient.getHandler().messageHandler(message, response);

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

		// ctx.close();

	}
}
*/