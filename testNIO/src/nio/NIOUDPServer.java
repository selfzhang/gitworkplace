package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class NIOUDPServer {
	private final int TIMEOUT=3000;
	DatagramChannel datagramChannel=null;
	Selector selector=null;
	ByteBuffer receBuffer=null;
	ByteBuffer sendBuffer=null;
	private int flag =1;
	SocketAddress remoteAddress=null;
	public NIOUDPServer (int port) throws IOException {
		datagramChannel=DatagramChannel.open();
		datagramChannel.configureBlocking(false);
		datagramChannel.socket().bind(new InetSocketAddress(port));
		selector=Selector.open();
		datagramChannel.register(selector, SelectionKey.OP_READ);
		receBuffer=ByteBuffer.allocate(4096);
		sendBuffer=ByteBuffer.allocate(4096);
		System.out.println("server start");
	}
	public void  listen() throws IOException {
		while(true){
			if(this.selector.select(TIMEOUT)==0){
				System.out.println("TIMEOUT");
				continue;
			}
			Iterator<SelectionKey> sIterator=selector.selectedKeys().iterator();
			while(sIterator.hasNext()){
				SelectionKey selectionKey=sIterator.next();
				sIterator.remove();
				handlermeg(selectionKey);
			}
		}
	}
	public void handlermeg(SelectionKey selectionKey) throws IOException{
		if(selectionKey.isReadable()){
			DatagramChannel channel=(DatagramChannel) selectionKey.channel();
			receBuffer.clear();
			String receText=null;

			remoteAddress = channel.receive(receBuffer);
			int recvLen = receBuffer.position();
						
			receText=new String(receBuffer.array(), 0, recvLen);
			if(recvLen>0){
				System.out.println("udp serer receive " + receText);
				channel.register(selector, SelectionKey.OP_WRITE);
			}
		}else if(selectionKey.isWritable()){
			DatagramChannel clientchannel=(DatagramChannel) selectionKey.channel();
			sendBuffer.clear();
			String sendText="DDPserver send msg "+flag ++;
			sendBuffer.put(sendText.getBytes());
			sendBuffer.flip();
			clientchannel.send(sendBuffer,remoteAddress);
			System.out.println("UDPServer send "+sendText);
			clientchannel.register(selector, SelectionKey.OP_READ);

		}
	}
	public static void main(String[] agr) throws IOException{
		NIOUDPServer NioudpServer=new NIOUDPServer(7080);
		NioudpServer.listen();
	}
}
