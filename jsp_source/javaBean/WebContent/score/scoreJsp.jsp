<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:useBean id = "scoreBean" class = "score.ScoreModel" scope = "page"/>
	<jsp:setProperty property="*" name="scoreBean"/>
<title>Insert title here</title>
</head>
<body>
	
	<%
		scoreBean.process();
	%>
	<table border = "1">
		<tr>
			<td>ID: </td>
			<td>
				<jsp:getProperty property="id" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Name: </td>
			<td>
				<jsp:getProperty property="name" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Kor: </td>
			<td>
				<jsp:getProperty property="kor" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Eng: </td>
			<td>
				<jsp:getProperty property="eng" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Mat: </td>
			<td>
				<jsp:getProperty property="mat" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Tot: </td>
			<td>
				<jsp:getProperty property="tot" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Avg: </td>
			<td>
				<jsp:getProperty property="evg" name="scoreBean"/>
			</td>
		</tr>
		<tr>
			<td>Grade: </td>
			<td>
				<jsp:getProperty property="grade" name="scoreBean"/>
			</td>
		</tr>
	</table>
</body>
</html>