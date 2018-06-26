<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forwarded page</h2>
	<table>
		<tr>
			<td>name : </td>
			<td><%=request.getParameter("name") %></td>
		</tr>
		<tr>
			<td>age : </td>
			<td><%=request.getParameter("age") %></td>
		</tr>
		<tr>
			<td>adress : </td>
			<td><%=request.getParameter("adress") %></td>
		</tr>
		<tr>
			<td>tel : </td>
			<td><%=request.getParameter("tel") %></td>
		</tr>
		<tr>
			<td>hidden : </td>
			<td><%=request.getParameter("forwardPage") %></td>
		</tr>
	</table>
</body>
</html>