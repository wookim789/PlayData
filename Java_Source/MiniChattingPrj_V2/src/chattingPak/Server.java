package chattingPak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server implements Runnable{
	
	private static ServerSocket serverSocket = null;
	private static Socket clientSocket = null;
	private static ArrayList <ServerThread> ClientSocketThreadList = new ArrayList<ServerThread>();
	
	private static BufferedReader readCLMsg = null;

	public static int numberOfUser = 0;
	
	
	public static void main(String[] args) {
		
		
	}
	
	public void run() {
		try {
			serverSocket = new ServerSocket(8000);
			readCLMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			while(true) {
				clientSocket = serverSocket.accept();
			}
			
		}
		catch(Exception e) {
			
		}
	}
}
