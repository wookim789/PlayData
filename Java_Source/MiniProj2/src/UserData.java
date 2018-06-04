import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.jdbc.OracleTypes;

public class UserData implements ActionListener, Runnable  {

	static private Container mainPanel;
	static private JFrame frame;
	static private JPanel tab, logIntab,IDPWtab,texttab,CreateTab ,CreateIDTab, msgPanel, msgInsert, buttonTab ;

	static private CardLayout clayout;

	static private JLabel logInLabel,Password, cridLab, crpwLab, crnameLab,crphoneLab,creamilLab;
	static private JTextField IDTextBox,PWTextBox, CR_ID, CR_PW, CR_Name, CR_Phone, CR_Email;
	
	static private JButton logInButton,createOKButton, createIDButton;

	static private String ip = "192.168.0.194";
	static private Socket socket;
	static private boolean status;
	static private BufferedReader inMsg = null;
	static private PrintWriter outMsg = null;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.194:1521:orcl";
	private Connection con = null;
	private CallableStatement cstmt = null;
	private BufferedReader br =null;
	private ResultSet rs =null;
	static public String id,pw,name,phone,email;

	UserData(){
		frame = new JFrame("LogIn");
		frame.setLocation(800,300);
		frame.setPreferredSize(new Dimension(350,350));
		frame.setResizable(false);
		
		//main panel
		mainPanel =  frame.getContentPane();
		FlowLayout layout = new FlowLayout();
		mainPanel.setLayout(layout);
	
		tab = new JPanel(new BorderLayout());
			clayout = new CardLayout();
			tab.setLayout(clayout);
			
			logIntab = new JPanel(new BorderLayout());	
							
			IDPWtab = new JPanel(new BorderLayout());
			GridLayout idpw = new GridLayout(2, 1);
			IDPWtab.setLayout(idpw);
				logInLabel = new JLabel("ID "); 
				Password = new JLabel("Pw ");
				IDPWtab.add(logInLabel);
				IDPWtab.add(Password);
				
			texttab = new JPanel(new BorderLayout());
			GridLayout texttab22= new GridLayout(2, 1);
			texttab.setLayout(texttab22);
				IDTextBox = new JTextField("",10);
				PWTextBox = new JTextField("",10);
				texttab.add(IDTextBox, BorderLayout.NORTH);
				texttab.add(PWTextBox, BorderLayout.SOUTH);
			
			buttonTab = new JPanel(new BorderLayout());		
				logInButton = new JButton("Log in");
				createIDButton = new JButton("Create ID");
				buttonTab.add(logInButton,BorderLayout.WEST);
				buttonTab.add((createIDButton),BorderLayout.EAST);
							
			logIntab.add(IDPWtab,BorderLayout.WEST);
			logIntab.add(texttab,BorderLayout.CENTER);
			logIntab.add(buttonTab,BorderLayout.EAST);
			
		CreateTab = new JPanel(new BorderLayout());
		FlowLayout layout1 = new FlowLayout();
		CreateTab.setLayout(layout1);
		
			CreateIDTab = new JPanel(new BorderLayout());	
				GridLayout gl = new GridLayout(5, 2);
				CreateIDTab.setLayout(gl);
				
				CR_ID = new JTextField("",10);
				CR_PW  = new JTextField("",10);
				CR_Name  = new JTextField("",10);
				CR_Phone  = new JTextField("",10);
				CR_Email  = new JTextField("",10);
		
				cridLab = new JLabel("ID");
				crpwLab = new JLabel("PW");
				crnameLab = new JLabel("Name");
				crphoneLab = new JLabel("Phone");
				creamilLab = new JLabel("Email");
				
				CreateIDTab.add(cridLab);
				CreateIDTab.add(CR_ID);
				CreateIDTab.add(crpwLab);
				CreateIDTab.add(CR_PW);
				CreateIDTab.add(crnameLab);
				CreateIDTab.add(CR_Name);
				CreateIDTab.add(crphoneLab);
				CreateIDTab.add(CR_Phone);
				CreateIDTab.add(creamilLab);
				CreateIDTab.add(CR_Email );
					
			createOKButton = new JButton("OK");
			
		CreateTab.add(CreateIDTab,BorderLayout.CENTER);
		CreateTab.add(createOKButton,BorderLayout.SOUTH);
		
		
		tab.add(logIntab,"login");
		tab.add(CreateTab, "Create");
		
		clayout.show(tab,"login");
		//clayout.show(tab,"Create");
				
		mainPanel.add(tab, BorderLayout.CENTER);
		
		createIDButton.addActionListener(this);
		logInButton.addActionListener(this);
		createOKButton.addActionListener(this);
		
		System.out.println(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserData ud = new UserData();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
	
		boolean idLog = false;
		if(obj == logInButton) {
			System.out.println("logInButton");
			
			id = this.IDTextBox.getText();
			pw = this.PWTextBox.getText();

			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, "PDuser", "123456");
				cstmt = con.prepareCall("{call idLogin(?,?)}"); //call 다음 call_selectp는 db에 등록되있는 프로시저 식별자다!
				cstmt.setString(1, id);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				cstmt.executeQuery();
				
				rs = (ResultSet)cstmt.getObject(2);
				
				while(rs.next()) {
					
					if(rs.getString("userPW").equals(pw) ) {
						System.out.println("log in : " + id + "welcome");
						idLog = true;
					}
				}
				
				if(idLog == true) {
//					Client client = new Client("127.0.0.1");
					Client client = new Client("192.168.0.194");
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
			
			
			
		}else if(obj == createIDButton) {
			System.out.println("createIDButton");
			
			clayout.show(tab,"Create");
			
		}else if(obj == createOKButton) {
			System.out.println("createOKButton");
			
			id = this.CR_ID.getText();
			pw = this.CR_PW.getText();
			name = this.CR_Name.getText();
			phone = this.CR_Phone.getText();
			email = this.CR_Email.getText();
			
			if(id != "" && pw != "") {
				try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, "PDuser", "123456");
					
					cstmt = con.prepareCall("{call insertTB(?,?,?,?,?)}"); //call 다음 call_selectp는 db에 등록되있는 프로시저 식별자다!
					cstmt.setString(1, id);
					cstmt.setString(2, pw);
					cstmt.setString(3, name);
					cstmt.setString(4, phone);
					cstmt.setString(5, email);

					cstmt.executeQuery();
					
					clayout.show(tab,"login");
					
					
				
					//cridLab.setText("ID");
				}catch(SQLException e) {
					System.out.println("아이디 중복");
					cridLab.setText("Already exist id");
					e.printStackTrace();
					
				}catch(Exception ig) {
					
				}
				finally {
					try{
						if(con != null) con.close();
						if(cstmt != null) cstmt.close();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
			
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
