<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Cookie cookie=new Cookie("name","hongkildong");
	cookie.setMaxAge(600);
	response.addCookie(cookie);
%>
<html>
<head>
<title>Cookie Test</title>
</head>
<body>
<h2><%=cookie.getName() %></h2>
<h2><%=cookie.getValue() %></h2>
<h2><%=cookie.getMaxAge() %></h2>
<a href="cookieTest2.jsp">쿠키 값 불러오기</a>
</body>
</html>
