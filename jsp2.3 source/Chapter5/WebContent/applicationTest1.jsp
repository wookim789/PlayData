<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Application Test</title>
</head>
<body>
<h2>application 테스트</h2>
<table border="1">
	<tr>
		<td>JSP 버전</td>
		<td><%=application.getMajorVersion() %>.<%=application.getMinorVersion() %></td>
	</tr>
	<tr>
		<td>컨테이너 정보</td>
		<td><%=application.getServerInfo() %></td>
	</tr>
	<tr>
		<td>웹 어플리케이션의 실제 파일시스템 경로</td>
		<td><%=application.getRealPath("/") %></td>
	</tr>
</table>
</body>
</html>
