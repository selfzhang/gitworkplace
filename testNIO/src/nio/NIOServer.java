package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	private int flag=1;
	private int blockSize = 4096;
	private ByteBuffer sendbuffer=ByteBuffer.allocate(blockSize);
	private ByteBuffer acceptbuffer=ByteBuffer.allocate(blockSize);
	private Selector selector;
	
	public NIOServer(int port) throws IOException{
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		//设置是否阻塞
		serverSocketChannel.configureBlocking(false);
		ServerSocket serverSocket=serverSocketChannel.socket();
		//绑定ip端口
		serverSocket.bind(new InetSocketAddress(port));
		//打开选择器
		selector=Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		System.out.println("Server start" + port);
		
	}
	//监听
	public void	listen() throws IOException {
		while(true){
			selector.select();
			Set<SelectionKey> selectionkeys=selector.selectedKeys();
			Iterator<SelectionKey> iterator=selectionkeys.iterator();
			while(iterator.hasNext()){
				SelectionKey selectionkey = iterator.next();
				iterator.remove();
				//业务逻辑
				handleKey(selectionkey);
			}
//			selectionkeys.clear();
		}
		
	}
	
	public void handleKey(SelectionKey selectionKey) throws IOException {
		ServerSocketChannel server=null;
		SocketChannel client=null;
		String ReceiveText;
		String sendText;
		int count =0;
		if(selectionKey.isAcceptable()){
			server=(ServerSocketChannel) selectionKey.channel();
			client=server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
			System.out.println("isaccept");
		}else if(selectionKey.isReadable()){
			acceptbuffer.clear();
			client=(SocketChannel)selectionKey.channel();
			count=client.read(acceptbuffer);
			if(count>0){
				ReceiveText =new String(acceptbuffer.array(),0,count);
				System.out.println("sever 接收到信息 " + ReceiveText);
				client.register(selector, SelectionKey.OP_WRITE);
			} 
		}else if(selectionKey.isWritable()){
			sendbuffer.clear();
			//send data
			client=(SocketChannel) selectionKey.channel();
			sendText="msg send to client"+flag++;
			sendbuffer.put(sendText.getBytes());
			sendbuffer.flip();
			client.write(sendbuffer);
			client.register(selector, SelectionKey.OP_READ);
			System.out.println("server send data to client" + sendText);
		}
	}
	public static void  main(String[] arg) throws IOException {
		int port=7080;
		NIOServer server =new NIOServer(port);
		server.listen();
	}
}
