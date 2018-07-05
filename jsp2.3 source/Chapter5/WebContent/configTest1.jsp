<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Config Test</title>
</head>
<body>
<h2>config 테스트</h2>
<table border="1">
	<tr>
		<td>초기 파라미터 이름</td>
		<td>초기 파라미터 값</td>
	</tr>
<%
Enumeration e=config.getInitParameterNames();
while(e.hasMoreElements()){
	String init_paramName=(String)e.nextElement();
	%>
	<tr>
		<td><%=init_paramName %></td>
		<td><%=config.getInitParameter(init_paramName) %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>
