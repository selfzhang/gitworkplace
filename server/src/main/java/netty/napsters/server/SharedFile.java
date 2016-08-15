package netty.napsters.server;

import java.io.Serializable;

public class SharedFile implements Serializable {
	/**
	 * The name of the file.
	 */
	private String fileName;

	/**
	 * The nick name who share the file.
	 */
	private String sharer;

	/**
	 * The checksum of the file.
	 */
	private String checksum;

	/**
	 * The size in Byte of the file.
	 */
	private long size;

	/**
	 * The unique ID for serializing.
	 */

	private static final long serialVersionUID = -4555154852215315632L;

	public SharedFile() {
	}

	public SharedFile(String fileName, String sharer, String checksum, long size) {
		this.fileName = fileName;
		this.sharer = sharer;
		this.checksum = checksum;
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSharer() {
		return sharer;
	}

	public void setSharer(String sharer) {
		this.sharer = sharer;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String toString() {
		return String.format("SharedFile [FileName=%s, Sharer=%s, Checksum=%s, Size=%d Byte]",
				new Object[] { fileName, sharer, checksum, size });
	}

}