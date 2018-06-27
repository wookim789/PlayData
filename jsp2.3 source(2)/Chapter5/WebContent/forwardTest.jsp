<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Forward Action Test</title>
</head>
<body>
<h2>포워드 액션 테스트</h2>
<form action="forwardTest1.jsp" method="POST">
<input type="hidden" name="forwardPage" value="forwardTest2.jsp">
<table>
	<tr>
		<td>이름	</td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td>나이	</td>
		<td><input type="text" name="age"></td>
	</tr>
	<tr>
		<td>주소	</td>
		<td><input type="text" name="address"></td>
	</tr>
	<tr><td><input type="submit" value="전송"></td></tr>
</table>
</form>
</body>
</html>
