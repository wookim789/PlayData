package server3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread{
	Socket socket;
	SenderThread(Socket socket){
		this.socket = socket;
	}
	BufferedReader reader;
	PrintWriter writer;
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String str = reader.readLine();
				System.out.println("test:" + str);
				if(str.equals("bye")) {
					break;
				}
				writer.println(str);
				writer.flush();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				socket.close();
			}catch(Exception ignored) {
				
			}
		}
	}
}

