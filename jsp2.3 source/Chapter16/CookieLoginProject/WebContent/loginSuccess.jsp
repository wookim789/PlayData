<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = 
	(Member)request.getAttribute("loginMember");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인에 성공한 사용자 정보</h1>
이름 : <%=loginMember.getName() %><br>
주소 : <%=loginMember.getAddr() %><br>
이메일 : <%=loginMember.getEmail() %><br>
나이 : <%=loginMember.getAge() %><br>
</body>
</html>