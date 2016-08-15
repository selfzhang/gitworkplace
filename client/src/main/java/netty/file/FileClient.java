package netty.file;

import netty.napsters.client.NettyClient;

public class FileClient {
	private String filePath = "";
	private String checkSum = "";

	private NettyClient fileClient;
	private static final FileClient INSTANCE = new FileClient();

	private FileClient() {
		fileClient = new NettyClient(new FileClientMessageHandler());
	}

	public String getFilePath() {
		return this.filePath;
	}

	public String getCheckSum() {
		return this.checkSum;
	}

	public static FileClient getInstance() {
		return INSTANCE;
	}

	public void connect(String ipAddress, String checksum, String filePath) {
		fileClient.fileClientconnect(ipAddress, checksum, filePath);
		this.filePath = filePath;
		this.checkSum=checksum;
	}
}
