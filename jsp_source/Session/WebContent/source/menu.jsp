<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	
</head>
	<%
		String id = (String)session.getAttribute("id");
	%>
<body>
	<%
		if(id == null){
	%>
			<a href = "login.jsp" target = "rightFrame">로그인</a>
		<% 
		}else{
		%>
			<%=id %>님 환영합니다.
		<% 
		}
		%>
</body>
</html>