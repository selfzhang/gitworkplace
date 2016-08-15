package netty.napsters.client;

public class NapsterClientMessageHandler implements NettyClientHandlerInterface {
	
	@Override
	public void messageHandler(String message, Response response) {
		// TODO Auto-generated method stub
		System.err.println("NettyClientMessageHandler"+message);
		if (message.startsWith("LIST ")) {

			response.setSharedFiles(message.substring(5));

		} else if (message.startsWith("ADD ")) {

			response.setShareFile(message);

		} else if (message.startsWith("DELETE ")) {

			response.setUnshareFile(message);

		} else if (message.startsWith("REQUEST ")) {
			response.setFileShareIp(message.substring(8));
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "NapsterClientMessageHandler";
	}

}
