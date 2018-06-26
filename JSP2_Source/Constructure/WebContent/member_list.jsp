<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="member.MemberDBBean" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import ="member.*" %>
<%
	MemberDBBean mdbb = MemberDBBean.getInstance();
	ArrayList<MemberDataBean> arr = mdbb.getDBListdata();
	
	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>
</head>
<body>
<table>
	<tr><td colspan=2 class="td_title">회원 목록</td></tr>

<%! int i =0; %>
<% 
	System.out.println(arr.size());
while(arr.size()>i){%>
	<tr>
		<td><a href="member_info.jsp?id=<%=arr.get(i).getId()%>"><%=arr.get(i).getId() %></a></td>
		<td><a href="member_updateList.jsp?id=<%=arr.get(i).getId()%>">수정</a></td>
		<td><a href="member_delete.jsp?id=<%=arr.get(i).getId()%>">삭제</a></td>	
		
	</tr>
	<%i++;} i=0;%>
</table>
</body>
</html>
