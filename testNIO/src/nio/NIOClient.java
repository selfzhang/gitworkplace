package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private static int flag=1;
	private static int blockSize = 4096;
	private static ByteBuffer sendbuffer=ByteBuffer.allocate(blockSize);
	private static ByteBuffer acceptbuffer=ByteBuffer.allocate(blockSize);
	private final static InetSocketAddress serverAddress =new InetSocketAddress("192.168.199.210", 7080);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SocketChannel socketChannel=SocketChannel.open();
		socketChannel.configureBlocking(false);
		//´òé_ßx“ñÆ÷
		Selector selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(serverAddress);
		
		Set<SelectionKey> selectionKeys;
		Iterator<SelectionKey> iterator;
		SelectionKey selectionKey;
		SocketChannel client=null;;
		String receiveText;
		String sendText;
		int count=1;
		
		while(true){
	    selector.select();
		selectionKeys=selector.selectedKeys();
		iterator=selectionKeys.iterator();

		while(iterator.hasNext()){
			selectionKey=iterator.next();

			if(selectionKey.isConnectable()){

				client=(SocketChannel) selectionKey.channel();
				System.out.println("client accept");
				if (client.isConnectionPending()) {
					client.finishConnect();
					System.out.println("client finish connectting");
					sendbuffer.clear();
					sendText="hello server";
					sendbuffer.put(sendText.getBytes());
					sendbuffer.flip();
					client.write(sendbuffer);
				}
				client.register(selector, SelectionKey.OP_READ);
			}if(selectionKey.isReadable()){
				client=(SocketChannel) selectionKey.channel();
				acceptbuffer.clear();
				count=client.read(acceptbuffer);
				if(count>0){
					receiveText=new String(acceptbuffer.array(), 0, count);
					System.out.println("client receive"+receiveText);
					client.register(selector, SelectionKey.OP_WRITE);
				}
			}if(selectionKey.isWritable()){
				sendbuffer.clear();
				client=(SocketChannel) selectionKey.channel();
				sendText="msg send to server"+flag++;
				sendbuffer.put(sendText.getBytes());
				sendbuffer.flip();
				client.write(sendbuffer);
				System.out.println("client send data to server "+ sendText);
				client.register(selector, SelectionKey.OP_READ);
			}
			
		}
		selectionKeys.clear();
		}
	}

}
