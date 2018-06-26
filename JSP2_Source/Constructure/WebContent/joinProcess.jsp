<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import = "member.MemberDBBean" %>

<jsp:useBean id = "memberdata" class = "member.MemberDataBean">
	<jsp:setProperty name = "memberdata" property="*"/>
</jsp:useBean>

<%
	MemberDBBean manager = MemberDBBean.getInstance();
	int result = manager.insertMember(memberdata);
	
	if(result !=0){
		out.println("<script>");
		out.println("alert('success')");
		out.println("location.href = 'loginForm.jsp'");
		out.println("</script>");
	}else{
		out.println("<script>");
		out.println("alert('failed')");
	  	out.println("location.href='joinForm.jsp'");
	  	out.println("</script>");	
	}
%>

