package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] arg) throws IOException {
		ServerSocket server = new ServerSocket(8081);
		Socket socket = null;
		String inputLine = "";
		BufferedReader in = null;
		OutputStream out = null;
		int c;
		boolean flag = false;
		while (!flag) {
			socket = server.accept();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.equals("stop")) {
					flag = false;
					break;
				} else {
					System.out.println(inputLine);
					while ((c = System.in.read()) != -1) {
						out.write(c);
						if (c == '\n') {
							out.flush();
							break;
						}
					}
			
				}
			}
		}
		in.close();
		out.close();
		server.close();
		socket.close();

	}

}
