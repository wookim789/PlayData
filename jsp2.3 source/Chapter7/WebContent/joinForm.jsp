<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>회원가입 폼</title>
<style>
	#formArea{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align : center;
	}
	h1{
		text-align: center;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "formArea">
<h1>회원정보 입력</h1>
<form action="joinChk.jsp" method="post">
<table>
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><input type="text" name="id" id = "id"></td>
	</tr>
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" id = "pass"></td>
	</tr>
	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" id = "name"></td>
	</tr>
	<tr>
		<td><label for = "sex">성별 : </label></td>
		<td>
			<input type="radio" name="sex" value="1" id = "sex" checked>남
			<input type="radio" name="sex" value="2">여
		</td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" id = "age"></td>
	</tr>
	<tr>
		<td><label for = "email">이메일주소 : </label></td>
		<td><input type="text" name="email" id = "email"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="가입">
			<input type="reset" value="다시 작성">
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>
