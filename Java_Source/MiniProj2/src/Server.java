import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public ServerSocket ss = null;
	public  Socket s = null;
	ArrayList <ChatThread> chList = new ArrayList<ChatThread>();
	
	
	public static void main(String[] args) {
		Server server = new Server ();
		server.start();
		
	}
	
	public void start() {
		
			 try {
				ss = new ServerSocket (8888);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println("server start");
			 
			 while(true) {
				System.out.println("s1");
				try {
					s = ss.accept();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				System.out.println("s1");
				
				ChatThread ct = new ChatThread();
				chList.add(ct);
				
				ct.start();
			 }
	}
	
	
	public  class ChatThread extends Thread {
		String msg;
		String [] rmsg;
		
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
		
		@Override
		public  void run() {
			System.out.println("스레드 실행");
			boolean status = true;
			try
			{
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(), true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			while(status) {
					try
					{
						msg = inMsg.readLine();
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rmsg = msg.split("/");
					System.out.println(rmsg.length);
					if(rmsg[1].equals("logout")) {
						chList.remove(this);
						msgSendAll("server/" + rmsg[0]+ "님이 종료 했습니다.");
						status = false;
					}
					else if(rmsg[1].equals("login")) {
						msgSendAll("server/" + rmsg[0]+ "님이 로그인 했습니다.");
					}
					else {
						msgSendAll(msg);
					}

			}
			this.interrupt();
			System.out.println("##" +  this.getName() + "stop");
			
		}
		void msgSendAll(String msg) {
			for(ChatThread ct : chList) {
				ct.outMsg.println(msg);
			}
		}
		
		
	}
}
