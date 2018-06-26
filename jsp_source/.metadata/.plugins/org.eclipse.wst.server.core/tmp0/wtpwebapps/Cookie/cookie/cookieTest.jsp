<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name","kim");
	cookie.setMaxAge(600);
	response.addCookie(cookie);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%=cookie.getName() %></h2>
	<h2><%=cookie.getValue() %></h2>
	<h2><%=cookie.getMaxAge() %></h2>
	<a href = "cookieTest2.jsp">쿠키 값 불러오기</a>
</body>
</html>