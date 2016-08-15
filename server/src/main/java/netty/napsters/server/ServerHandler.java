package netty.napsters.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ServerHandler extends SimpleChannelInboundHandler<Object> {
	private static final Logger LOGGER = LogManager.getLogger(ServerHandler.class);
	private Map<NioSocketChannel, String> users = new HashMap<>();
	private FileServer fileServer = FileServer.getInstance();

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

		String command = (String) arg1;

		LOGGER.debug("Received new message: " + command);
		NioSocketChannel socket = (NioSocketChannel) arg0.channel();
		String sendMessage = "";
		System.out.println("Received new message: " + command + socket.localAddress());
		// Check if the user has logged in
		if (command == null || command.equals("QUIT")) {
			// The user is willing to leave
			String nickName = users.get(socket);
			LOGGER.info("User leaved " + nickName + ", Current Online Users: " + (users.size() - 1));

			if (!fileServer.unshareFiles(socket)) {
				LOGGER.warn("Failed to unshare files shared by " + socket);
			}
			users.remove(socket);



		} else if (!users.containsKey(socket)) {
			if (!command.startsWith("CONNECT ")) {

				sendMessage = "[WARN] Socket is going to close.";
				socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

			} else {
				String nickName = command.substring(7);

				sendMessage = "ACCEPT";
				socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

				users.put(socket, nickName.trim());
				LOGGER.info("New user joined " + nickName + ", Current Online Users: " + users.size());
			}
		} else {
			// Invoke FileServer for other request
			if (command.startsWith("ADD ")) {
				SharedFile sharedFile = JSON.parseObject(command.substring(4), SharedFile.class);
				boolean isFileShared = fileServer.shareNewFile(sharedFile, socket);

				if (isFileShared) {
					sendMessage = "ADD OK";
					socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

				} else {
					sendMessage = "ADD ERROR";
					socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

				}
			} else if (command.startsWith("DELETE ")) {

				@SuppressWarnings("unchecked")
				Map<String, String> sharedFile = JSON.parseObject(command.substring(7), HashMap.class);
				String checksum = sharedFile.get("checksum");
				boolean isFileUnshared = fileServer.unshareFile(checksum, socket);

				if (isFileUnshared) {
					sendMessage = "DELETE OK";
					socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

				} else {
					sendMessage = "DELETE ERROR";
					socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

				}

			} else if (command.equals("LIST")) {
				List<SharedFile> sharedFiles = fileServer.getSharedFiles();

				sendMessage = "LIST "+JSON.toJSONString(sharedFiles);
				socket.writeAndFlush(Unpooled.copiedBuffer(sendMessage.getBytes()));

			} else if (command.startsWith("REQUEST ")) {
				String checksum = command.substring(8);
				String sharerIp ="REQUEST "+ fileServer.getFileSharerIp(checksum);

				socket.writeAndFlush(Unpooled.copiedBuffer(sharerIp.getBytes()));
			}
		}

	}

}
