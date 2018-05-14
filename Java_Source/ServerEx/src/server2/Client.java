package server2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		Socket socket = null; 
		
		try {                  //loopback address 내 컴에서 내부적으로 사용하기 위한 주소
			socket = new Socket("127.9.0.1",9000);

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new PrintWriter(socket.getOutputStream()));
			
			writer.print("hello server");
			writer.flush();
			
			String str = reader.readLine();
			System.out.println(str);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				
			}
		}

	}


}
