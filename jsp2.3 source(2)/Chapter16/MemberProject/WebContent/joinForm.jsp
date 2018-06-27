<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#joinformArea{
		width : 400px;
		margin : auto;
		border : 1px solid gray;
	}
	table{
		width : 380px;
		margin :  auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "joinformArea">
<form name="joinform" action="./memberJoinAction.me" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>회원가입 페이지</h1>
		</td>
	</tr>
	<tr>
		<td><label for = "MEMBER_ID">아이디 : </label> </td>
		<td><input type="text" name="MEMBER_ID" id = "MEMBER_ID"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_PW">비밀번호 : </label></td>
		<td><input type="password" name="MEMBER_PW" id = "MEMBER_PW"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_NAME">이름 : </label></td>
		<td><input type="text" name="MEMBER_NAME" id = "MEMBER_NAME"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_AGE">나이 : </label></td>
		<td><input type="text" name="MEMBER_AGE" maxlength="2" id = "MEMBER_AGE"/></td>
	</tr>
	<tr>
		<td><label for = "MEMBER_GENDER">성별 : </label></td>
		<td>
			<input type="radio" name="MEMBER_GENDER" value="남" checked="checked" id = "MEMBER_GENDER"/>남자
			<input type="radio" name="MEMBER_GENDER" value="여"/>여자
		</td>
	</tr>
	<tr>
		<td><label for = "MEMBER_EMAIL">이메일 주소 : </label></td>
		<td><input type="text" name="MEMBER_EMAIL" id = "MEMBER_EMAIL"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>