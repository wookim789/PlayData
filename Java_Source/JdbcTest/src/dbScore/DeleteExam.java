package dbScore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteExam {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		BufferedReader br = null;
		
		String hakbun = null;
		int res = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블 값 삭제하기.....");
			System.out.println("학번 입력 : ");
			hakbun = br.readLine();
			
			String sql = "Delete from member where hakbun = '" + hakbun + "'";
			System.out.println(sql);
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			
			if(res == 1) {
				System.out.println("삭제 성공!");
			}
			else {
				System.out.println("삭제실패");
			}
			
		}catch(Exception e) {
			System.out.println("데이터 베이스 연결 실패 " + e.getMessage());
		}
		finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
