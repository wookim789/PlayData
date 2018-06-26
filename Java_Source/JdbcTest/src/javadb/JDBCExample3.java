package javadb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample3 {
	//자바에서 오라클 db에 접속 이후 접속 종류 시 자동 커밋이 된다.

	public static void main(String[] args) {
		String drvier ="oracle.jdbc.driver.OracleDriver";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //대소문자 구분할 것
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","123456"); //127.0.0.1 로컬 ip
			stmt = conn.createStatement();
			
			System.out.println("조회할 상품코드 입력 => ");
			
			String s_code = in.readLine();
			String sql = "select code, name, price, maker " + "from goodsinfo where code= '" + s_code + "'";
			
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("\n상품코드 상품명 \t\t가격 제조사");
			System.out.println("-----------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
				
			}
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 크래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				rs.close();
			}
			catch(Exception ignored) {
				
			}
			try {
				stmt.close();
			}
			catch(Exception ignored) {
				
			}
			try {
				conn.close();
			}catch(Exception ignored){
				
			}
			try {
				in.close();
			}catch(Exception ignored) {
				
			}
		}

	}

}
