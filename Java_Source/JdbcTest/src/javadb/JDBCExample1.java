package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {

	public static void main(String[] args) {
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "123456");
	         System.out.println("데이터베이스에 접속했습니다,");
	         
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(
	        		 				"select code, name, price, maker from goodsinfo");
	         System.out.println("상품코드 상품명 \t\t가격 제조사");
	         System.out.println("--------------------------------------------");
	         
	         while(rs.next()) {
	        	 String code = rs.getString("code");
	        	 String name = rs.getString("name");
	        	 int price = rs.getInt("price");
	        	 String maker = rs.getString("maker");
	        	 System.out.printf("%8s %s  \t%12d %s%n",code, name, price, maker);
	         }
	         
       
	      }
	      catch (ClassNotFoundException cnfe) {
	         System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
	      }
	      catch(SQLException se) {
	         System.out.println(se.getMessage());
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
	    	  }
	    	  catch(Exception ignored) {
	    		  
	    	  }
	      }
	   }
}
