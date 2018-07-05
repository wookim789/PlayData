<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="net.member.db.MemberBean" %>
<%
	MemberBean member=(MemberBean)request.getAttribute("member");
	String MEMBER_ZIPCODE=member.getMEMBER_ZIPCODE();
	String MEMBER_EMAIL=member.getMEMBER_EMAIL();
	String MEMBER_EMAIL_GET=member.getMEMBER_EMAIL_GET();	
	String[] zipcodes=MEMBER_ZIPCODE.split("-");	//"-"로 구분함
	String[] email=MEMBER_EMAIL.split("@");	//"@"로 구분함
%>
<html>
<head>
<title>쇼핑몰</title>
<script>
function check(form){
	var pass1=infoform.MEMBER_PW.value;
	var pass2=infoform.MEMBER_PW2.value;
	var email1=infoform.MEMBER_EMAIL1.value;				
	var email2=infoform.MEMBER_EMAIL2.value;
	var tel=infoform.MEMBER_PHONE.value;
	var addr=infoform.MEMBER_ADDR1.value;
	var addr_about=infoform.MEMBER_ADDR2.value;
	var phone=infoform.MEMBER_MOBILE.value;
	
	var forms = document.getElementById("infoform");

	if ((forms.MEMBER_NAME.value=="")||(forms.MEMBER_NAME.value.length<=1)){
		alert("이름을 입력하세요.");
		forms.MEMBER_NAME.focus();
        return false;
	}
	if(pass1.length == 0){
		alert("비밀번호를 입력하세요.");
		infoform.MEMBER_PW.focus();
		return false;
	} 
	if(pass1 != pass2){
		alert("비밀번호가 일치하지 않습니다.");
		infoform.MEMBER_PW.value="";
		infoform.MEMBER_PW2.value="";
		infoform.MEMBER_PW.focus();
		return false;
	} 				 
	if(email1.length == 0 || email2.length == 0){
		alert("이메일 주소를 입력하세요.");
		infoform.MEMBER_EMAIL1.focus();
		return false;
	}
	if(tel.length == 0){
		alert("집 전화를 입력하세요.");
		infoform.MEMBER_PHONE.focus();
		return false;
	} 
	if((forms.MEMBER_ZIPCODE1.value=="")||(forms.MEMBER_ZIPCODE1.value.length<3)){
		alert("우편번호 앞의 3자리를 입력해 주세요.");
      	forms.MEMBER_ZIPCODE1.focus();
         	return false;
 		}
 	if((forms.MEMBER_ZIPCODE2.value=="")||(forms.MEMBER_ZIPCODE2.value.length<3)){
		alert("우편번호 뒤의 3자리 입력해 주세요.");
      	forms.MEMBER_ZIPCODE2.focus();
        return false;
	}   
	if(addr.length == 0){
		alert("집 주소를 입력하세요.");
		infoform.MEMBER_ADDR1.focus();
		return false;
	} 
	if(addr_about.length == 0){
		alert("상세 주소를 입력하세요.");
		infoform.MEMBER_ADDR2.focus();
		return false;
	} 
	if(phone.length == 0){
		alert("전화번호를 입력하세요.");
		infoform.MEMBER_MOBILE.focus();
		return false;
	}
	
	return true;
}

function openzipcode(joinform){			
	var url="./Zipcode.me";	
	open(url, "confirm", "toolbar=no,location=no,status=no,menubar=no,"+
						 "scrollbars=yes,resizable=no,width=410,height=400");
}

function gNumCheck(){
	if(event.keyCode >=48 && event.keyCode <=57) {
		return true;
	}else{
		event.returnValue=false;	
	}
}

function out(){
	var Answer = confirm("회원탈퇴를 하시겠습니까?");
 		if (Answer == true){ 
 		location.href = "./MemberOut.me";
 	}
 }
</script>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0" align="center">
<tr>
<td colspan=2>
<!-- 개인정보 수정 -->
<p align="center">
<form action="./MemberModifyAction_2.me" method="post" name="infoform" 
		onsubmit="return check(this)">
<table border="1" width="80%" height="80%">
	<tr>
		<td width="17%" bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이름</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_NAME" 
				size="20" value="${member.MEMBER_NAME }" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;ID</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;${member.MEMBER_ID }
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;비밀번호</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="password" name="MEMBER_PW" size="15"/>
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;비밀번호 확인</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="password" name="MEMBER_PW2" size="15" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">&nbsp;</td>
		<td>
		<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;
		(아이디와 비밀번호는 문자와 숫자를 조합하여 2~12자리로 만들어 주세요)</font>
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;주민등록번호</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;&nbsp;
			${member.MEMBER_JUMIN1 } - ${member.MEMBER_JUMIN2}
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;이메일 주소</font>
		</td>
		<td>
		&nbsp;&nbsp;&nbsp;
		<input type="text" name="MEMBER_EMAIL1" size="13" 
			value="<%=email[0].trim() %>" /> @ 
		<input type="text" name="MEMBER_EMAIL2" size="13" 
			value="<%=email[1].trim() %>" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;메일 수신 여부</font>
		</td>
		<td>
		&nbsp;&nbsp;&nbsp;
		<input type="radio" name="MEMBER_EMAIL_GET" 
		value="YES" <%if(MEMBER_EMAIL_GET.equals("YES")){%>checked<%} %>/>
		<font size="2">수신</font>
		&nbsp;&nbsp;
		<input type="radio" name="MEMBER_EMAIL_GET" 
		value="NO" <%if(MEMBER_EMAIL_GET.equals("NO")){%>checked<%} %>/>
		<font size="2">수신 안함</font>
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;집 전화</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_PHONE" size="24" 
				value="${member.MEMBER_PHONE }" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;우편번호</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_ZIPCODE1" 
				size="6" onkeypress="gNumCheck()" 
				maxlength="3" value="<%=zipcodes[0].trim() %>" /> - 
			<input type="text" name="MEMBER_ZIPCODE2" 
				size="6" onkeypress="gNumCheck()" 
				maxlength="3" value="<%=zipcodes[1].trim() %>" />&nbsp;&nbsp;
			<input type="button" name="zipcode" 
				value="우편번호 검색" onclick="openzipcode(this.form)" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;집 주소</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_ADDR1" size="50" 
				value="${member.MEMBER_ADDR1 }" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;상세 주소</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_ADDR2" size="50" 
				value="${member.MEMBER_ADDR2 }" />
		</td>
	</tr>
	<tr>
		<td bgcolor="#f5f5f5">
			<font size="2">&nbsp;&nbsp;&nbsp;&nbsp;휴대폰</font>
		</td>
		<td>
			&nbsp;&nbsp;&nbsp;
			<input type="text" name="MEMBER_MOBILE" size="24" 
				value="${member.MEMBER_MOBILE }" />
		</td>
	</tr>
</table>

<table width="80%">
	<tr>
		<td align="center">
			<br/><input type="submit" value="회원정보 수정" />
			<input type="button" value="회원 탈퇴" name="bt" onclick="out()" />
		</td>
	</tr>
</table>
</form>
<!-- 개인정보 수정 -->
</td>
</tr>	
</table>
</body>
</html>