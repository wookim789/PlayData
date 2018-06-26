package dbEx2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertExam2 {

	public static void main(String[] args) {
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement ptmt = null;
		BufferedReader br = null;
		
		String sql = "Insert Into member(hakbun, name, addr, phone) Values (?, ?, ?, ?)";
		String hakbun, name, addr, phone;
		int res = 0;
		
		try{
			br = new BufferedReader (new InputStreamReader (System.in));
			
			System.out.println("Member 테이블에 값 추가하기 .....");
			System.out.println("학번 입력 : ");
			hakbun = br.readLine();
			System.out.println("이름 입력 : ");
			name = br.readLine();
			System.out.println("주소 입력 : ");
			addr = br.readLine();
			System.out.println("전화번호 입력 : ");
			phone = br.readLine();

			System.out.println(sql);
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, "scott", "123456");
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1,hakbun);
			ptmt.setString(2,name);
			ptmt.setString(3,addr);
			ptmt.setString(4,phone);
			ptmt.executeUpdate();
			

		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패 ! = " + e.getMessage());
		}
		finally {
			try {
				if(con!=null)con.close();
				if(ptmt!=null)ptmt.close();
				if(br!=null)br.close();
			}catch(Exception ignored) {}
		}
	}
}
