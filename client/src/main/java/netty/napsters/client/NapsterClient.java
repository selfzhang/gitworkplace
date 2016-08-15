package netty.napsters.client;

public class NapsterClient {
	private NettyClient napsterClient;
	private static final NapsterClient INSTANCE = new NapsterClient();

	private NapsterClient() {
		napsterClient = new NettyClient(new NapsterClientMessageHandler());
	}

	public static NapsterClient getInstance() {
		return INSTANCE;
	}

	public void connect(String ipAddress, String nickName) {
		napsterClient.connect(ipAddress, nickName);
	}

	public void disconnect() {
		// TODO Auto-generated method stub
		this.napsterClient.disconnect();
	}

	public void sendListCommond(String string, Response response) {
		// TODO Auto-generated method stub
		this.napsterClient.sendCommond(response.sendListCommond(string));
	}

	public void sendADDCommond(String string, Response response) {
		// TODO Auto-generated method stub
		this.napsterClient.sendCommond(response.sendADDCommond(string));
	}

	public void sendUnshareFileCommond(String fileName, String checksum, Response response) {
		// TODO Auto-generated method stub
		this.napsterClient.sendCommond(response.sendUnshareFileCommond(fileName, checksum));
	}

	public void sendRequestCommond(String string, Response response) {
		// TODO Auto-generated method stub
		this.napsterClient.sendCommond(response.sendRequestCommond(string));
	}
	
	
}
