<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String name ="";
	String value = "";
	String cookie = request.getHeader("Cookie");
	
	if(cookie!=null){
		Cookie cookies[] = request.getCookies();
		
		for(int i =0; i<cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				name = cookies[i].getName();
				value = cookies[i].getValue();
			}
		}
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>cookie name = <%=name %></h2>
	<h2>cookie value = <%=value %></h2>
</body>
</html>