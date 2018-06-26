<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="member.MemberDBBean" %>
<%
	System.out.println("업데이트문서");
	String id=null;
	request.setCharacterEncoding("UTF-8");
	String id_update=request.getParameter("id");
	System.out.println(id_update);
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String gender=request.getParameter("gender");
	String email=request.getParameter("email");


	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("alert('aa')");
		out.println("</script>");

	}
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	System.out.println("업데이트문서1") ;
	try {
			Context init = new InitialContext();
			DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
			pstmt=conn.prepareStatement("UPDATE member SET password = ?, name = ?, age = ?,gender = ?, email = ?  WHERE id=?");
			pstmt.setString(1,pass);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setString(4,gender);
			pstmt.setString(5,email);
			pstmt.setString(6,id_update);
			
			pstmt.executeUpdate();
			
			System.out.println("업데이트문서2") ;
			out.println("<script>");
			out.println("location.href='member_list.jsp'");
			out.println("</script>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			pstmt.close();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>
