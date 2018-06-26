<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>`
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>썸네일 이미지 폼 예제</h3>
	<form action ="thumbnail.jsp" method ="post" enctype = "multipart/form-data">
		이미지 파일 : <input type = "file" name = "filename">
		<input type ="submit" value ="전송">
	</form>
</body>
</html>