<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	String id=null;
	if ((session.getAttribute("id")==null) || 
			(!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
	
	String update_id=request.getParameter("id");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
			Context init = new InitialContext();
			DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
			
			pstmt=conn.prepareStatement("SELECT * FROM member WHERE id=?");
			pstmt.setString(1,update_id);
			rs=pstmt.executeQuery();
			rs.next();
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 정보 수정)</title>
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
</style>
</head>
<body>
<form name="member_update" action="updateProcess.jsp" method="post">
<table>
	<tr>
		<td><label for = "id">아이디 : </label></td>
		<td><%=rs.getString("id") %></td>
		<input type="hidden" name="id" value="<%=rs.getString("id")%>" />
		
	</tr>
	
	<tr>
		<td><label for = "pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" value="<%=rs.getString("password") %>"/></td>
	</tr>
	<tr>
		<td><label for = "name">이름 : </label></td>
		<td><input type="text" name="name" value="<%=rs.getString("name") %>"/></td>
	</tr>
	<tr>
		<td><label for = "age">나이 : </label></td>
		<td><input type="text" name="age" value="<%=rs.getString("age")%>"/>
		</td>
	</tr>
	<tr>
		<td><label for = "gender1"></label>성별 : </td>
		<td>
		<%
			if(rs.getString("gender").equals("남"))
			{
		%>
				<input type="radio" name="gender" value="남" id = "gender1" checked/>남자
				<input type="radio" name="gender" value="여" id = "gender2"/>여자
		<%
			}
			else
			{
		%>
			<input type="radio" name="gender" value="남" id = "gender1"/>남자
			<input type="radio" name="gender" value="여" id = "gender2" checked/>여자
		<%
			}
		%>
		</td>
	</tr>
	<tr>
		<td><label for = "email">이메일 주소 : </label></td>
		<td><input type="text" name="email" value="<%=rs.getString("email") %>"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:member_update.submit()">수정</a>&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td colspan=2><a href="member_list.jsp">리스트로 돌아가기</a></td>
	</tr>
</table>
</form>
</body>
</html>
