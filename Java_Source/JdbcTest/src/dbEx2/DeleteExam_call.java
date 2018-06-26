package dbEx2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DeleteExam_call {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		BufferedReader br = null;
		
		String hakbun = null;
//		int res = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 삭제하기.....");
			System.out.println("학번 입력 : ");
			hakbun = br.readLine();
			
//			String sql = "Delete from member where hakbun = ?";
//			System.out.println(sql);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			cstmt = con.prepareCall("{call call_delete(?)}");
			cstmt.setString(1, hakbun);
			cstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("데이터 베이스 연결 실패 " + e.getMessage());
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
