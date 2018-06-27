<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>FileUpload Form</title>
<style>
	#uploadFormArea{
		margin : auto;
		width : 350px;
		border : 1px solid black;
	}
	.td_title{
		font-size: xx-large;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "uploadFormArea">
<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td colspan="2" class = "td_title" >파일 업로드 폼</td>
	<tr>
		<td><label for = "name">올린 사람 : </label></td><td><input type="text" name="name" id = "name"></td>
	</tr>
	<tr>
		<td><label for = "subject">제목 : </label></td><td><input type="text" name="subject" id = "subject"></td>
	</tr>
	<tr>
		<td><label for = "fileName1">파일명1 : </label></td><td><input type="file" name="fileName1" id = "fileName1"></td>
	</tr>
	<tr>
		<td><label for = "fileName2">파일명2 : </label></td><td><input type="file" name="fileName2" id = "fileName2"></td>
	</tr>
	<tr>
		<td colspan=2 align=center><input type="submit" value="전송"></td>
	</tr>
</table>
</form>
</section>
</center>
</body>
</html>
