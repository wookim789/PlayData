package server4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread{
	
	static List<PrintWriter> list 
							= Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket socket;
	PrintWriter writer;
	
	PerClientThread(Socket socket){
		this.socket = socket;
		
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		}catch(Exception e) {
			System.out.println("erro -> PerClientThead : 24");
		}
	}
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			
			sendAll("#" + name + "님 입장");
			
			while(true) {
				String str = reader.readLine();
				if(str == null) {
					break;
				}
				sendAll(name + ">"+str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			list.remove(writer);
			sendAll("#"+name+"님 퇴장");
		}
	}
	
	public void sendAll(String str) {
		for(PrintWriter writer : list) {
			writer.println(str);
			writer.flush();
		}
	}

}
