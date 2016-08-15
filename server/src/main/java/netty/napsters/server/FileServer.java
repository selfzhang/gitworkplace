package netty.napsters.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.channel.socket.nio.NioSocketChannel;

public class FileServer {
	/**
	 * The list of shared files.
	 */
	private static final Map<String, Map<String, Object>> sharedFiles = new Hashtable<>();

	/**
	 * The unique instance of File server.
	 */
	private static final FileServer INSTANCE = new FileServer();

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = LogManager.getLogger(FileServer.class);

	private FileServer() {
	}

	public static FileServer getInstance() {
		return INSTANCE;
	}

	public List<SharedFile> getSharedFiles() {
		List<SharedFile> sharedFileList = new ArrayList<>();

		for (Map.Entry<String, Map<String, Object>> e : sharedFiles.entrySet()) {
			sharedFileList.add((SharedFile) e.getValue().get("sharedFile"));
		}
		return sharedFileList;
	}

	public boolean shareNewFile(SharedFile sharedFile, NioSocketChannel socket) {
		String checksum = sharedFile.getChecksum();

		if (sharedFiles.containsKey(checksum)) {
			return false;
		}

		String ipAddress = socket.localAddress().toString();

		Map<String, Object> meta = new HashMap<>();
		meta.put("ipAddress", ipAddress);
		meta.put("socket", socket);
		meta.put("sharedFile", sharedFile);
		sharedFiles.put(checksum, meta);

		LOGGER.info("File shared at " + socket + ", " + sharedFile);
		return true;
	}

	public boolean unshareFile(String checksum, NioSocketChannel socket) {
		if (socket == null || !sharedFiles.containsKey(checksum)) {
			return false;
		}

		Map<String, Object> sharedFileMeta = sharedFiles.get(checksum);
		SharedFile sharedFile = (SharedFile) sharedFileMeta.get("sharedFile");
		NioSocketChannel s = (NioSocketChannel) sharedFileMeta.get("socket");

		if (!socket.equals(s)) {
			return false;
		}
		sharedFiles.remove(checksum);
		LOGGER.info("File unshared at " + socket + ", " + sharedFile);
		return true;
	}

	public boolean unshareFiles(NioSocketChannel socket) {
		if (socket == null) {
			return false;
		}

		Iterator<Map.Entry<String, Map<String, Object>>> itr = sharedFiles.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Map<String, Object>> e = itr.next();
			NioSocketChannel s = (NioSocketChannel) e.getValue().get("socket");
			SharedFile sharedFile = (SharedFile) e.getValue().get("sharedFile");

			if (socket.equals(s)) {
				itr.remove();
				LOGGER.info("File unshared at " + socket + ", " + sharedFile);
			}
		}
		return true;
	}

	public String getFileSharerIp(String checksum) {
		if (!sharedFiles.containsKey(checksum)) {
			return "ERROR";
		}

		String ipAddress = (String) sharedFiles.get(checksum).get("ipAddress");
		return ipAddress;
	}

}
