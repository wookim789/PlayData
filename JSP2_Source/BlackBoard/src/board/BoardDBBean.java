package board;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class BoardDBBean {
   private static BoardDBBean instance = new BoardDBBean();

   public static BoardDBBean getInstance() {
      return instance;
   }

   private BoardDBBean() {
   }

   private Connection getConnection() throws Exception {
      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
      return ds.getConnection();
   }
   
   private void close(ResultSet rs, PreparedStatement pstmt, Connection conn)
   {
      if(rs != null)
         try {
            rs.close();
         }catch(SQLException ex) {
         }
      
      if (pstmt != null)
         try {
            pstmt.close();
         } catch (SQLException ex) {
         }
      
      if (conn != null)
         try {
            pstmt.close();
         } catch (SQLException ex) {
         }
   }

   public ArrayList<BoardDataBean> getArticles(int start, int end) throws Exception
   {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      ArrayList<BoardDataBean> articleList = null;
      String sql = null;
      
      try
      {
         conn = getConnection();
         
         sql = "select * from" +
               "(select rownum rnum, num, writer, passwd, " +
               "subject, email, content, reg_date, "+
               "readcount, ref, re_step, re_level from "+
               "(select * from board order by ref desc, re_step asc))" +
               "where rnum>=? and rnum<=?";
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, start);
         pstmt.setInt(2, end);
         rs=pstmt.executeQuery();
         
         if(rs.next())
         {
            articleList = new ArrayList<BoardDataBean>();
            do
            {
               BoardDataBean article = new BoardDataBean();
               article.setNum(rs.getInt("num"));
               article.setWriter(rs.getString("writer"));
               article.setPasswd(rs.getString("passwd"));
               article.setSubject(rs.getString("subject"));
               article.setEmail(rs.getString("email"));
               article.setContent(rs.getString("content"));
               article.setReg_date(rs.getTimestamp("reg_date"));
               article.setReadcount(rs.getInt("readcount"));
               article.setRef(rs.getInt("ref"));
               article.setRe_step(rs.getInt("re_step"));
               article.setRe_level(rs.getInt("re_level "));
               
               articleList.add(article);
            }while(rs.next());
         }
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         close(rs, pstmt, conn);
      }
      
      return articleList;
   }

public int getArticleCount() throws Exception{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count = 0;
	
	try {
		conn = getConnection();
		
		pstmt = conn.prepareStatement("select count(*) from board");
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			count = rs.getInt(1);
		}
	}catch (Exception ex) {
		ex.printStackTrace();
		// TODO: handle exception
	}finally {
		close(rs,pstmt,conn);
	}
	return count;
}

}