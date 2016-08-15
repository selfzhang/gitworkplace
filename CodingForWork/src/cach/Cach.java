package cach;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cach {
	private Map<String, Object> cachMap = new HashMap<String, Object>();
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public Object getData(String key) {
		readWriteLock.readLock().lock();
		Object object = null;
		try {
			object = cachMap.get(key);
			if (object == null) {
				readWriteLock.readLock().unlock();
				readWriteLock.writeLock().lock();
				try {
					if (object == null) {
						object = "asf";
					}
				} finally {
					readWriteLock.writeLock().unlock();
				}
				readWriteLock.readLock().lock();
			}
		} finally {

			readWriteLock.readLock().unlock();

		}

		return object;

	}

}
