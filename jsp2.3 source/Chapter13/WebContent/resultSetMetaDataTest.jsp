<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
 	Connection conn = null;
 	String sql = "SELECT * FROM student";
 	PreparedStatement pstmt = null;
 	ResultSet rs = null;
 	ResultSetMetaData rsmd = null;
 	
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
  		conn = ds.getConnection();
  		
  		pstmt = conn.prepareStatement(sql);
  		rs = pstmt.executeQuery();
		rsmd = rs.getMetaData();

		out.println("칼럼 수 : "+rsmd.getColumnCount()+"<br>");
		for(int i=1;i<=rsmd.getColumnCount();i++){
			out.println(i+"번째 칼럼의 이름 : " + rsmd.getColumnName(i)+" : ");
			out.println(i+"번째 칼럼의 타입 이름 : " +rsmd.getColumnTypeName(i)+"<br>");
		}
	}catch(Exception e){
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
