<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<html>
<head>
<title>Attribute Test</title>
</head>
<body>
<h2>영역과 속성 테스트</h2>
<table border="1">
	<tr><td colspan="2">Application 영역에 저장된 내용들</td></tr>
	<tr>
		<td>이름</td>
		<td><%=application.getAttribute("name") %></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=application.getAttribute("id") %></td>
	</tr>
</table>
<br>
<table border="1">
	<tr><td colspan="2">Session 영역에 저장된 내용들</td></tr>
<%
Enumeration e=session.getAttributeNames();
while(e.hasMoreElements()){
	String attributeName=(String)e.nextElement();
	String attributeValue=(String)session.getAttribute(attributeName);
	%>
	<tr>
		<td><%=attributeName %></td>
		<td><%=attributeValue %></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>
