<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:useBean id ="beantest" class= "test.BeanTest" scope="page"/>
<jsp:setProperty name = "beantest" property = "name" value ="hello"/>
<%
	 beantest.setName("hello2"); 
%>
</head>
<body>
	<b>자바빈 사용 예제</b>
	<h3><%=beantest.getName() %></h3>
	<jsp:getProperty name = "beantest" property = "name"/>
	
</body>
</html>