package dbEx2;

import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.BufferedReader;

public class InsertExam_CALL {

	public static void main(String[] args) {
		String drvier = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		
//		String sql = "Insert Into member (hakbun, name, addr, phone) Values(?,?,?,?)";
		String hakbun, name, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			System.out.println("테이블 값추가");
			
			System.out.println("학번 입력 : ");
			hakbun = br.readLine();
			System.out.println("이름 입력 : ");
			name = br.readLine();
			System.out.println("주소 입력 : ");
			addr = br.readLine();
			System.out.println("전화번호 입력 : ");
			phone = br.readLine();
			
//			System.out.println(sql);
			Class.forName(drvier);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			
			cstmt = con.prepareCall("{call call_insert(?,?,?,?)}");
			cstmt.setString(1, hakbun);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
	
			cstmt.executeUpdate();
			System.out.println("데이터베이스 연결성공!");
			
			}catch(Exception e) {
				System.out.println("데이터 베이스 연결 실패 = "+ e.getMessage());
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
