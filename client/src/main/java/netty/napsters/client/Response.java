package netty.napsters.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.alibaba.fastjson.JSON;

import netty.file.SharedFile;

public class Response {
	private List<SharedFile> sharedFiles = new ArrayList<>();
	private String shareFileFlag = "";
	private String unshareFlag = "";
	private String fileShareIp = "";

	private boolean setFlag = false;

	public String sendListCommond(String string) {

		return string;
	}

	public void setSharedFiles(String response) {

		synchronized (sharedFiles) {

			this.sharedFiles = JSON.parseArray(response, SharedFile.class);

		}
	}

	public List<SharedFile> getSharedFiles() {

		synchronized (sharedFiles) {

			return this.sharedFiles;

		}

	}

	/**
	 * Share a new file to Napster server.
	 * 
	 * @param sharedFile
	 *            the file to share
	 * @return whether the share operation is successful
	 */
	public String sendADDCommond(String commond) {
		setFlag = true;
		return commond;
	}

	public void setShareFile(String response) {

		synchronized (shareFileFlag) {
			while (!setFlag) {
				try {
					shareFileFlag.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (response.equals("ADD OK")) {
				this.shareFileFlag = "true";
			} else {
				this.shareFileFlag = "false";
			}
			setFlag = false;
			shareFileFlag.notifyAll();
		}

	}

	public String shareNewFile() {

		// Receive response from server
		synchronized (shareFileFlag) {
			while (setFlag) {
				try {
					shareFileFlag.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			shareFileFlag.notifyAll();
			return this.shareFileFlag;

		}

	}

	/**
	 * Unshare a file from Napster server.
	 * 
	 * @param fileName
	 *            the file name of the file
	 * @param checksum
	 *            the checksum of the file
	 * @return whether the unshare operation is successful
	 */
	public String sendUnshareFileCommond(String fileName, String checksum) {

		String Commond = "DELETE " + JSON.toJSON(((Supplier<Map<String, String>>) (() -> {
			Map<String, String> map = new HashMap<String, String>();
			map.put("fileName", fileName);
			map.put("checksum", checksum);
			return Collections.unmodifiableMap(map);
		})).get());
		setFlag = true;
		return Commond+"\r\n";

	}

	public void setUnshareFile(String response) {

		synchronized (unshareFlag) {
			while (!setFlag) {
				try {
					unshareFlag.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (response.equals("DELETE OK")) {
				this.unshareFlag = "ture";
			} else {
				this.unshareFlag = "false";
			}
			setFlag = false;
			unshareFlag.notifyAll();

		}

	}

	public String unshareFile() {

		synchronized (unshareFlag) {
			while (setFlag) {
				try {
					unshareFlag.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			unshareFlag.notifyAll();

			return this.unshareFlag;
		}

	}

	/**
	 * Get the IP of the sharer who share a specific file
	 * 
	 * @param checksum
	 *            the checksum of the file
	 * @return the IP of the sharer or N/a if the file is not available
	 */
	public String sendRequestCommond(String commond) {
		setFlag = true;
		return commond;
	}

	public void setFileShareIp(String response) {

		synchronized (fileShareIp) {
			while (!setFlag) {
				try {
					fileShareIp.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!response.equals("ERROR")) {

				this.fileShareIp = response;
			} else {
				this.fileShareIp = "N/a";
			}
			setFlag = false;
			fileShareIp.notifyAll();
		}
	}

	public String getFileSharerIp() {

		synchronized (fileShareIp) {
			while (setFlag) {
				try {
					fileShareIp.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fileShareIp.notifyAll();
			return this.fileShareIp;
		}

	}
}
