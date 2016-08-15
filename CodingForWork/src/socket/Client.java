package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket socket=null;
		OutputStream outputStream=null;
		BufferedReader in=null;
		try {
			 socket = new Socket("127.0.0.1", 8081);
			 outputStream = socket.getOutputStream();
			 in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int c;
			String responseLine="";
			while(true){
				while((c=System.in.read())!=-1){
					outputStream.write(c);
					if(c=='\n'){
						outputStream.flush();
						break;
					}
				}
				responseLine=in.readLine();
				System.out.println("receive "+responseLine);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.close();
		in.close();
		socket.close();
	}

}
