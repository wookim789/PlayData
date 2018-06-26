package dbScore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExam {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.194:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "Select * from member";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "SCOTT", "123456");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("hakun\tname\taddr\tphone");
			System.out.println("------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getString("hakbun")+ "\t");
				System.out.println(rs.getString("name")+ "\t");
				System.out.println(rs.getString("addr")+ "\t");
				System.out.println(rs.getString("phone")+ "\t");
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
				if(rs != null)rs.close();
			}catch(Exception e) {
			}
		}

	}

}
