<%@page import="vo.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
	#memberListArea{
		width : 400px;
		border : 1px solid gray;
		margin : auto;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "memberListArea">
<table>
	<tr>
		<td colspan=2><h1>회원 목록</h1></td>
	</tr>
	<c:forEach var = "member" items = "${memberList}">
	<tr>
		<td>
			<a href="memberViewAction.me?id=${member.MEMBER_ID}">
				${member.MEMBER_ID}
			</a>
		</td>
		<td>
		<a href="memberDeleteAction.me?id=${member.MEMBER_ID}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</section>
</body>
</html>