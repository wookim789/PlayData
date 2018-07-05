<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/> 
<meta http-equiv="Pragma" content="no-cache"/> 

<title>Insert title here</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
System.out.println(id);
if(id==null){
	response.sendRedirect("/ShoppingMall-Example/MemberLogin.me");
}
else{
%>
<a href="/ShoppingMall-Example/MemberModifyAction_1.me">회원정보수정</a>
<%
}
%>
</body>
</html>