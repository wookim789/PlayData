package server4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread {
	
	Socket socket;
	String name;
	
	BufferedReader reader;
	PrintWriter writer;
	
	SenderThread(Socket socket, String name){
		this.socket = socket;
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			//writer 객체를 통해 socket.getOutputStram을 
		    reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			
			writer.println(name);
			writer.flush();
			
			while(true) {
				String str = reader.readLine();
				
				if(str.equals("bye")) {
					break;
				}
				//socket에 문자열 저장 - > 메세지 전달
				writer.println(str);
				writer.flush();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}catch(Exception e) {
				System.out.println("erro -> Sender : 45"+e.getMessage());
			}
		}
	}
	

}
