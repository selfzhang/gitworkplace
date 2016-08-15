package netty.file;

import java.io.File;
import java.io.RandomAccessFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyFileServerHandler extends SimpleChannelInboundHandler<Object> {
	private static final Logger LOGGER = LogManager.getLogger(NettyFileServerHandler.class);


	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

		String command = (String) arg1;

		LOGGER.debug("Received new message: " + command);
		NioSocketChannel socket = (NioSocketChannel) arg0.channel();
		System.out.println("Received new message: " + command + socket.localAddress());
		String sendMessage = "";
		if (command.startsWith("GET ")) {
			String checksum = command.substring(4, 36);

			if (NettyFileServer.sharedFiles.containsKey(checksum)) {
				File file = new File(NettyFileServer.sharedFiles.get(checksum));
				if (!file.exists()) {
					System.out.println("WARN] NO FILE");
				} else {
					RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
					FileRegion region = new DefaultFileRegion(randomAccessFile.getChannel(), 0,
							randomAccessFile.length());
					arg0.writeAndFlush(region);

					randomAccessFile.close();
				}
			} else {
				sendMessage = "[WARN] NO FILE .";
				socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

			}
		}
	}

}