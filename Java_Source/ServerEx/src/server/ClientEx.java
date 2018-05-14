package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClientEx {

	public static void main(String[] args) {
		Socket socket = null; 
		
		try {                  //loopback address 내 컴에서 내부적으로 사용하기 위한 주소
			socket = new Socket("127.9.0.1",9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			String str = "hello, server";
			out.write(str.getBytes());
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
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
