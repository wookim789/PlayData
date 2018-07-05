<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1><%=getStr() %> </h1>
<%!
private String getStr(){
	str+="테스트입니다.";
	return str;
}
private String str="선언문 "; 
%>