<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="beantest" class ="test.BeanTest" scope="page"/>
<jsp:setProperty name = "beantest" property ="name" param ="name"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>자바빈 사용</b>
	<h3><%=beantest.getName() %></h3>
	<h3><jsp:getProperty property="name" name="beantest"/></h3>
</body>
</html>