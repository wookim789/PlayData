<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
 	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql="INSERT INTO student (num, name) VALUES (13,'홍길동')";
	String sql2="SELECT * FROM student WHERE num=12"; 	
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
  		conn = ds.getConnection();
  		
  		conn.setAutoCommit(false);
  		
  		pstmt=conn.prepareStatement(sql);
  		pstmt.executeUpdate();
  		
  		pstmt=conn.prepareStatement(sql2);
  		rs=pstmt.executeQuery();
  		if(!rs.next()){
  			conn.rollback();
  			out.println("<h3>데이터 삽입에 문제가 발생하여 롤백하였습니다.</h3>");
  		}else{
  			conn.commit();
  			out.println("<h3>데이터 삽입이 모두 완료되었습니다.</h3>");
  		}
  
  		conn.setAutoCommit(true);
	}catch(Exception e){
		out.println("<h3>데이터 삽입에 실패하였습니다.</h3>");
		e.printStackTrace();
 	}finally{
 		try{
 			rs.close();
 			pstmt.close();
 			conn.close();
 		}
 		catch(Exception e){
 			e.printStackTrace();
 		}
 	}
%>
