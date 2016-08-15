package netty.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import netty.napsters.client.ApplicationBootstrap;
import netty.napsters.client.NettyClientHandlerInterface;
import netty.napsters.client.Response;

@SuppressWarnings("restriction")
public class FileClientMessageHandler implements NettyClientHandlerInterface {
	private static final Logger LOGGER = LogManager.getLogger(FileClientMessageHandler.class);

	@Override
	public void messageHandler(String message, Response response) {
		// TODO Auto-generated method stub

		File file = new File(ApplicationBootstrap.fileClient.getFilePath());
		RandomAccessFile randomAccessFile = null;


		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			randomAccessFile = new RandomAccessFile(file, "rw");
			long fileLength = randomAccessFile.length();// 获取文件的长度即字节数
			// 将写文件指针移到文件尾
			randomAccessFile.seek(fileLength);
			randomAccessFile.write(message.getBytes());



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				randomAccessFile.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FileClientMessageHandler";
	}

}
