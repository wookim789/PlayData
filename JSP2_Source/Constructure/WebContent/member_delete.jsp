<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import = "member.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	String delete_id=request.getParameter("id");
	

	
	try {
			MemberDBBean mdbb = MemberDBBean.getInstance();
			mdbb.getDBlistDel(delete_id);
			
			out.println("<script>");
			out.println("location.href='member_list.jsp'");
			out.println("</script>");
	}catch(Exception e){
		e.printStackTrace();
	}
%>
