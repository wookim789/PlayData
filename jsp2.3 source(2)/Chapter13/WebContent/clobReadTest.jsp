<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
 	Connection conn = null; 
 	PreparedStatement pstmt = null;
	StringBuffer sb = null;
	ResultSet rs = null;
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
  		conn = ds.getConnection();
		pstmt=conn.prepareStatement("SELECT * FROM clobtable WHERE num=1");
  	   	rs = pstmt.executeQuery();
  	   	if(rs.next()){
  	    	out.println(rs.getString("content"));	
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
