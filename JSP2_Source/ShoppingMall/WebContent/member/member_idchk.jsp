<%@ page contentType="text/html; charset=utf-8" %>
<%
	String id=(String)request.getAttribute("id");
	int check=((Integer)(request.getAttribute("check"))).intValue();
%>
<html>
<head>
<title>쇼핑몰</title>
<script>
function windowclose(){
	opener.document.joinform.MEMBER_ID.value="<%=id %>";
	self.close();
}
</script>
</head>
<body bgcolor="#f5f5f5">
<% if(check == 1){ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
	<td height="30">
		<font size="2"><%=id %> 는 이미 사용 중인 아이디입니다.</font>
	</td>
	</tr>
</table>

<form action="./MemberIDCheckAction.me" method="post" name="checkForm" >
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		<font size="2">다른 아이디를 선택하세요.</font><p>
		<input type="text" size="10" maxlength="12" name="MEMBER_ID"/>
		<input type="submit" value="중복확인" />
	</td>					
	</tr>
</table>
</form>
<% }else{ %>
<table width="360" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center">
		<font size="2">입력하신 <%=id %> 는 사용할 수 있는 아이디입니다.</font>
		<br/><br/>
		<input type="button" value="닫기" onclick="windowclose()" />
		</td>
	</tr>
</table>
<% } %>
</body>
</html>