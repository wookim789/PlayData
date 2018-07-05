<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%
	String addr="";
	String zipcode="";
	String zip1="";
	String zip2="";	
	List zipcodeList=(ArrayList)request.getAttribute("zipcodelist");
%>

<html>
<head>
<title>쇼핑몰</title>
<script>
function setZipcode(zip1,zip2,addr){
	opener.document.forms[0].MEMBER_ZIPCODE1.value=zip1;
	opener.document.forms[0].MEMBER_ZIPCODE2.value=zip2;
	opener.document.forms[0].MEMBER_ADDR1.value=addr;
	self.close();
}
</script>
</head>
<body bgcolor="#f5f5f5">
<center>
<table width="370" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
		<td align="center">
			<font color="#ff4500">-우편번호 검색-</font><br>
		</td>
	</tr>
</table>
<form action="./MemberZipcodeAction.me" method="post" name="form">
<table width="370" border="0" cellspacing="0" cellpadding="5">
	<tr align="center">
		<td align="center">
			<font size="2">지역명 : </font>
			<input type="text" name="dong"/>
			<input type="submit" value="검색"><br>
			<font size="2">동을 입력하세요.(예:방배, 원천, 2글자 이상입력)</font>
		</td>
	</tr>
</table>
</form>
<br>
<table width="370" border="0" cellspacing="0" cellpadding="5">
<tr height="35">
	<td align="center" colspan="2">-검색결과-</td>
</tr>
<%	
	if(zipcodeList!=null && zipcodeList.size()!=0){	
		for(int i=0;i<zipcodeList.size();i++){
			String data=(String)zipcodeList.get(i);
			
			StringTokenizer st=new StringTokenizer(data,",");
			zipcode=st.nextToken();
			addr=st.nextToken();
			
			zip1=zipcode.split("-")[0];
			zip2=zipcode.split("-")[1];
%>
<tr>
	<td width="20%">
	<a href="#"	onclick="setZipcode(<%=zip1%>,<%=zip2%>,'<%=addr %>')">
		<font size="2"><%=zipcode%></font>
	</a>
	</td>
	<td width="80%"><font size="2"><%=addr %></font></td>
</tr>
<%		}
	}else{ %>
<tr>
	<td colspan="2" align="center">검색 결과가 없습니다.</td>
</tr>
<%	}%>
</table>
</center>
</body>
</html>