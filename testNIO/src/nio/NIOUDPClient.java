package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class NIOUDPClient {

	private static final long TIMEOUT = 3000;
	static DatagramChannel datagramChannel = null;
	static Selector selector = null;
	static ByteBuffer receBuffer = null;
	static ByteBuffer sendBuffer = null;
	private static int flag = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		datagramChannel = DatagramChannel.open();
		datagramChannel.configureBlocking(false);

		datagramChannel.socket().connect(new InetSocketAddress("127.0.0.1", 7080));
		selector = Selector.open();
		datagramChannel.register(selector, SelectionKey.OP_WRITE);
		receBuffer = ByteBuffer.allocate(4096);
		sendBuffer = ByteBuffer.allocate(4096);
		System.out.println("client start");

		Set<SelectionKey> selectionKeys;
		Iterator<SelectionKey> iterator;
		SelectionKey selectionKey;
		DatagramChannel client = null;
		String receiveText;
		String sendText;
		int count = 1;
		while (true) {
			if (selector.select(TIMEOUT) == 0) {
				System.out.println("TIMEOUT");
				continue;
			}
			selector.select();
			selectionKeys = selector.selectedKeys();
			iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				selectionKey = iterator.next();

				if (selectionKey.isWritable()) {
					client = (DatagramChannel) selectionKey.channel();
					sendText = "client send msg " + flag++;
					sendBuffer.clear();
					sendBuffer.put(sendText.getBytes());
					sendBuffer.flip();
					client.write(sendBuffer);
					System.out.println("client send msg " + sendText);
					client.register(selector, SelectionKey.OP_READ);
				}
				if (selectionKey.isReadable()) {
					client = (DatagramChannel) selectionKey.channel();
					receBuffer.clear();
					count = receBuffer.position();

					receiveText = new String(receBuffer.array(), 0, count);
					if (count > 0) {
						receiveText = new String(receBuffer.array(), 0, count);
						System.out.println("client receive msg " + receiveText);
						client.register(selector, SelectionKey.OP_WRITE);
					}
				}
			}
		}
	}

}
