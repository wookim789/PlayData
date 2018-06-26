<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%session.setAttribute("id", request.getParameter("id")); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>lonin success</h3>
	<h3>id : <%=(String)session.getAttribute("id") %></h3>
	<a href ="sessionLogout.jsp">logout</a>
</center>
</body>
</html>