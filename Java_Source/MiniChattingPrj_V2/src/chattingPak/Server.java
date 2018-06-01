package chattingPak;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private static ServerSocket serverSocket = null;
	private static Socket clientSocket = null;
	private static ArrayList <ServerThread> serverThreadList = new ArrayList<ServerThread>();

	public static void main(String[] args) {
		
		start();

	}
	
	private static void start() {
		try {
			System.out.println("서버 포트 생성");
			serverSocket = new ServerSocket(8888);
		}catch(IOException e) {
			System.out.println("서버 포트 생성 에러");
			e.printStackTrace();
		}
		
		
	}
}
