package dbEx2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateExam_call {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		BufferedReader br = null;
		
		String hakbun, addr, phone;
		
		try {
			br = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Memeber 테이블에 값 갱신하기 .....");
			System.out.println("갱신할 학번 입력");
			hakbun = br.readLine();
			System.out.println("새 주소 입력 : ");
			addr = br.readLine();
			System.out.println("새 전화번호 입력 : ");
			phone = br.readLine();
			
//			String sql = "Update member Set addr = ?, phone = ? where hakbun = ?";
			
//			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			cstmt = con.prepareCall("{call call_update(?,?,?)}");
			cstmt.setString(1,hakbun);
			cstmt.setString(2,addr);
			cstmt.setString(3,phone);
			cstmt.executeUpdate();

			System.out.println("데이터 베이스 내용 갱신 성공!");
			
			 
		}catch( Exception e) {
			System.out.println("데이터베이스 연결 실패!" + e.getMessage());
		}
		finally {
			try {
				if(cstmt != null) cstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
