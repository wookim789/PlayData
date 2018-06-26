package dbScore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExam {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		BufferedReader br = null;
		int res = 0;
		
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
			
			String sql = "Update member Set addr = ' " + "addr', " + "phone = '" + phone + "' where hakbun = '" + hakbun +  "'";
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			stmt = con.createStatement();
			res = stmt.executeUpdate(sql);
			
			if(res == 1) {
				System.out.println("수정 성공!");
			}
			else {
				System.out.println("수정 실패!");
			}
			System.out.println("데이터 베이스 내용 갱신 성공!");
			
			
		}catch( Exception e) {
			System.out.println("데이터베이스 연결 실패!" + e.getMessage());
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
