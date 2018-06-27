<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Include Action Test</title>
</head>
<body>
<h2>인클루드 액션 테스트</h2>
<jsp:include page="includeTest2.jsp">
	<jsp:param name="name" value="hongkildong"/>
</jsp:include>
</body>
</html>
