<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Cookie cookie=new Cookie("language",request.getParameter("language")); 
	cookie.setMaxAge(60*60*24);
	response.addCookie(cookie);
%>
<script>
location.href="cookieExample1.jsp"
</script>
