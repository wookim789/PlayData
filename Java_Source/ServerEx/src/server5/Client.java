package server5;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class Client implements ActionListener, Runnable {

static private Container mainPanel;
static private JFrame frame;
static private JPanel tab, logIntab, logOuttab, msgPanel, msgInsert ;
static private JScrollPane scrollPanel;

static private CardLayout clayout;

static private JLabel logInLabel, logOutLabel;
static private JTextField logInTextBox,  msgInsertText;
static private JTextArea msgText;
static private JButton logInButton, logOutButton, exitButton;

static private String userName,id,ip = "192.168.0.110";
static public Socket socket;
static private boolean status;
static private BufferedReader inMsg = null;
static private PrintWriter outMsg = null;
private Thread thread;

Client(String ip){
	userName = null;
	
	frame = new JFrame("멀티 채팅");
	frame.setLocation(800,300);
	frame.setPreferredSize(new Dimension(400,500));
	frame.setResizable(false);
	
	//main panel
	mainPanel =  frame.getContentPane();
	
	//tab ui
	tab = new JPanel();
		clayout = new CardLayout();
		tab.setLayout(clayout);
	
		logIntab = new JPanel(new BorderLayout());	
		logInLabel = new JLabel("대화명");
		logInButton = new JButton("확인");
		logInTextBox = new JTextField();	
		logIntab.add(logInLabel,BorderLayout.WEST);
		logIntab.add(logInButton,BorderLayout.EAST);
		logIntab.add(logInTextBox,BorderLayout.CENTER);
		//버튼 이벤트 등록
		logInButton.addActionListener(this);
	
		logOuttab = new JPanel(new BorderLayout());
		logOutLabel = new JLabel("대화명 :");
		logOutButton = new JButton("로그아웃");	
		logOuttab.add(logOutLabel,BorderLayout.WEST);
		logOuttab.add(logOutButton,BorderLayout.EAST);
		//버튼 이벤트 등록
		logOutButton.addActionListener(this);
		
	tab.add(logIntab,"login");
	tab.add(logOuttab,"logout");
	
	//Text ui
	msgPanel = new JPanel(new BorderLayout());
	msgText = new JTextArea("",10,30);
	msgText.setEditable(false);
	
	
	scrollPanel = new JScrollPane(msgText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	scrollPanel.setPreferredSize(new Dimension(50, 50));
	msgPanel.setLayout(new BorderLayout());
	msgPanel.add(scrollPanel, BorderLayout.CENTER);
	
	//Text Insert ui
	msgInsert = new JPanel();
	exitButton = new JButton("종료");
	msgInsertText = new JTextField();
	
	msgInsertText.addActionListener(this);
	exitButton.addActionListener(this);
	
	msgInsert.setLayout(new BorderLayout());
	msgInsert.add(exitButton,BorderLayout.EAST);
	msgInsert.add(msgInsertText,BorderLayout.CENTER);
	

	
	mainPanel.add(tab,BorderLayout.NORTH);
	mainPanel.add(msgPanel,BorderLayout.CENTER);
	mainPanel.add(msgInsert,BorderLayout.SOUTH);
	
	clayout.show(tab,"login");

 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client("192.168.0.110");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		
		//종료 처리
		if(obj == exitButton) {
			System.out.println("종료");
			System.exit(0);
		}else if(obj == logInButton ) {
			System.out.println("로그인");
			clayout.show(tab, "logout");
			id = logInTextBox.getText();
			logInLabel.setText("대화명 : ");
			logOutLabel.setText("대화명 : "+ id);
			connectServer();
			
		}else if(obj ==logOutButton  ) {
			System.out.println("로그아웃");
			outMsg.println(id+"/"+"logint");
			logOutLabel.setText(" ");
			logInTextBox.setText("");
			clayout.show(tab, "login");
			try {
				outMsg.close();
				socket.close();
			}catch(Exception e) {
				
			}
			status =false;
			
		}else if(obj == msgInsertText) {
			System.out.println("메세지 입력");
			outMsg.println(id + "/" + msgInsertText.getText());
			msgInsertText.setText(" ");
		}
		
	}
	
	public void connectServer() {
		try {
			socket = new Socket("192.168.0.103",8888);
			
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(),true);
			outMsg.println(id+"/"+"login");
			thread = new Thread(this);
			thread.start();
			System.out.println("서버 연결 성공");
			
		}catch(Exception e) {
			
		}
	}
	
	public void run() {
		String msg;
		String [] rmsg;
		
		status = true;
		while(status) {
			try {
				msg = inMsg.readLine();
				rmsg = msg.split("/");
				msgText.append(rmsg[0] + ">"+ rmsg[1] + "\n");
				
				msgText.setCaretPosition(msgText.getDocument().getLength());
				
			}catch(Exception e){
				status = false;
				
			}
		}
	}

}
