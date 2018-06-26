<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키, url/url 요청 방식에 관련된 정보 예제</h1>
<table border = "1">
	<tr>
		<td>쿠키정보</td>
		
		<%
			Cookie[] cookie = request.getCookies();
			if(cookie == null){
				%>
				<td>cookie null</td>
				<%		
			}else{
				for(int i = 0; i<cookie.length;i++){
					%>
					<td><%=cookie[i].getName() %>(<%=cookie[i].getValue() %>)&nbsp;&nbsp;</td>
				<%
				}
			}
			%>
	</tr>
	
	<tr>
		<td>server domain</td>
		<td><%=request.getServerName()%></td>
	<tr>
		<td>server port num</td>
		<td><%=request.getServerPort() %></td>
	</tr>
	
	<tr>
		<td>request url</td>
		<td><%=request.getRequestURI() %></td>
	</tr>
	
	<tr>
		<td>요청url</td>
		<td><%=request.getRequestURI() %></td>
	</tr>
	<tr>
		<td> request qurey</td>
		<td><%=request.getQueryString() %></td>
	</tr>
	<tr>
		<td>client host name</td>
		<td><%=request.getRemoteHost() %></td>
	</tr>
	<tr>
		<td>protocal</td>
		<td><%=request.getProtocol() %></td>
	</tr>
	<tr>
		<td>how to request </td>
		<td><%=request.getMethod() %></td>
	</tr>
	<tr>
		<td>context location</td>
		<td><%=request.getContextPath() %></td>
	</tr>
	
</table>









</body>
</html>