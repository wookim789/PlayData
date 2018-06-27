<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setMaxInactiveInterval(10);
%>
<html>
<head>
<title>Session Test</title>
</head>
<body>
<h2>세션 테스트</h2>
isNew():<%=session.isNew()%><br>
생성시간:<%=session.getCreationTime()%><br>
최종 접속 시간:<%=session.getLastAccessedTime()%><br>
세션ID:<%=session.getId()%><br>
</body>
</html>
