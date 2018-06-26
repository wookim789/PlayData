<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
%>
</head>
<body>
아이디 = <%=id  %><br>
비밀번호 =<%=id %><br>
</body>
</html>