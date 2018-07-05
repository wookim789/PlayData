<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>EL 내장객체 사용 예제</title>
</head>
<body>
<h3>${sessionScope.test}</h3>
<h3>${param.name }</h3>
</body>
</html>
