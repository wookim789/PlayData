<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="sessionLogin2.jsp" method="post">
	<table border =0 width=400 height =100>
		<tr bgcolor = "yellow">
			<td align =right><font size = 2>아이디</font></td>
			<td><input type="text" name = "id" size =10></td>
		</tr>
		<tr bgcolor = "yellow">
			<td align = right><font size =2>password</font></td>
			<td><input type="password" name="pass" size =12></td>
		</tr>
		<tr bgcolor="yellow">
			<td colspan =2 align = center>
				<input type = "submit" value ="login">
				<input type = "reset" value = "rewrite">
			</td>
		</tr>
				
	</table>
</form>
</body>
</html>