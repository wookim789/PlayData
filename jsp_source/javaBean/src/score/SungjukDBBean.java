package score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SungjukDBBean {
   private static SungjukDBBean instance = new SungjukDBBean();
   
   public static SungjukDBBean getInstance() {
      return instance;
   }
   
   private SungjukDBBean() {
      
   }
   
   private Connection getConnection() throws Exception {
      Connection conn = null;
      
      try {
         String driver = "oracle.jdbc.driver.OracleDriver";
         String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
         
         Class.forName(driver);
         conn = DriverManager.getConnection(url, "hr", "123456");
      }
      
      catch(Exception e) {
         System.out.println("Fail to connect DB");
         e.printStackTrace();
      }
      
      return conn;
   }
   
   public int insertSungjuk(ScoreModel data) throws Exception {
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      int result = 0;
      
      try {
         String driver = "oracle.jdbc.driver.OracleDriver";
         String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
         
         Class.forName(driver);
         conn = DriverManager.getConnection(url, "hr", "123456");
         
         pstmt = conn.prepareStatement("insert into sungjuck values(?, ?, ?, ?, ?, ?, ?, ?)");
         pstmt.setString(1, data.getId());
         pstmt.setString(2, data.getName());
         pstmt.setString(3, data.getKor());
         pstmt.setString(4, data.getEng());
         pstmt.setString(5, data.getMat());
         pstmt.setString(6, data.getTot());
         pstmt.setString(7, data.getEvg());
         pstmt.setString(8, data.getGrade());
         result = pstmt.executeUpdate();
      }
      
      catch(Exception e) {
         System.out.println("Fail to connect Database");
         e.printStackTrace();
      }
      
      finally {
         if(pstmt != null) {
            try {
               pstmt.close();
            }
            catch(SQLException ex) {
               
            }
         }
         if(conn != null) {
            try {
               conn.close();
            }
            catch(SQLException ex) {
               
            }
         }
      }
      
      return result;
   }
}