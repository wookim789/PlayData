<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "forwardTest2.jsp" method = 'POST'>
		<input type = "hidden" name = "forwardPage" value ="forwardTest3.jsp">
	
		
		<table>
			<tr>
				<td>name</td>
				<td><input type = "text" name = "name"></td>
				 
			</tr>
			<tr>
				<td>age </td>
				<td><input type = "text"  name ='age'></td>
			</tr>
			
			<tr>
				<td>adress </td>
				<td><input type = "text" name = "adress" ></td>
				
			</tr>
			<tr><td><input type = "submit" value ="send"></td></tr>
		</table>
	</form>
</body>
</html>