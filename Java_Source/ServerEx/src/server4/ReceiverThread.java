package server4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	BufferedReader reader;
	ReceiverThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String str = reader.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
		}catch(Exception e) {
			System.out.println("error -> Receiver : 25"+ e.getMessage());
		}
	}
}
