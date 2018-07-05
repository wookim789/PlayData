<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="net.order.db.*"%>
<%@ page import="net.member.db.*"%>
<%
	OrderBean order=(OrderBean)request.getAttribute("order");
	MemberBean ordermember=(MemberBean)request.getAttribute("ordermember");
%>
<html>
<head>
<title>쇼핑몰</title>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	align="center">
<tr>
<td colspan=2 align=center>
<!-- 주문 정보 수정(관리자) -->
<form action="./AdminOrderModify.ao" name="orderform" method="post">
<input type="hidden" name="num" value="<%=order.getORDER_NUM() %>">
<table width=80% border=0 cellpadding="0" cellspacing="1">
	<tr><td height=10></td></tr>
	<tr><td height=10></td></tr>
	<tr>
	<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;"
		width=130 height=24 bgcolor="f7f7f7">운송장(등기)번호</td>
	<td width=320 height=24><input type="text" name="transportnum"
		size=15 maxlength=20
		value=<%if(order.getORDER_TRANS_NUM()!=null){%>
		<%=order.getORDER_TRANS_NUM()%> <%} %>></td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;"
			width=130 height=24 bgcolor="f7f7f7">주문번호</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">
		<%=order.getORDER_TRADE_NUM() %></td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;"
			width=130 height=24 bgcolor="f7f7f7" colspan=2>상품 정보</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">상품이름</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_GOODS_NAME() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=23>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">수량</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_GOODS_AMOUNT() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">사이즈</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_GOODS_SIZE()%>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">색깔</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_GOODS_COLOR() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;"
			width=130 height=24 bgcolor="f7f7f7" colspan=2>배송지 정보</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">받는사람</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_RECEIVE_NAME() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=23>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">집전화</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_RECEIVE_PHONE() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">휴대폰</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_RECEIVE_MOBILE()%>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">배송지 주소</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_RECEIVE_ADDR1() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">배송지 나머지 주소</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=order.getORDER_RECEIVE_ADDR2() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;"
			width=130 height=24 bgcolor="f7f7f7" colspan=2>주문자 정보</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">이메일주소</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=ordermember.getMEMBER_EMAIL() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=23>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">집전화</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=ordermember.getMEMBER_PHONE() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">휴대폰</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=ordermember.getMEMBER_MOBILE() %>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr height=20>
		<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
			bgcolor="f7f7f7">기타 요구사항</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
		<textarea name="memo" cols=60 rows=12><%=order.getORDER_MEMO() %>
		</textarea>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
</table>

<table width=80% border=0 cellpadding="0" cellspacing="1">
	<tr><td height=10></td></tr>
	<tr><td height=10></td></tr>
	<tr>
		<td><b><font size=2>결제 정보</font></b></td>
	</tr>
	<tr>
		<td style="font-family: Tahoma; font-size: 8pt;" width=200 height=24
			bgcolor="f7f7f7">주문 합계금액 :</td>
		<td width=320 height=24>
			<font size=2><%=order.getORDER_SUM_MONEY() %>원</font>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr>
		<td style="font-family: Tahoma; font-size: 8pt;" width=200 height=24
			bgcolor="f7f7f7">결제방법 :</td>
		<td width=320 height=24>
			<font size=2><%=order.getORDER_TRADE_TYPE() %></font>
		</td>
	</tr>
	<tr>
		<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
	</tr>
	<tr>
		<td style="font-family: Tahoma; font-size: 8pt;" width=200 height=24
			bgcolor="f7f7f7">입금자명 :</td>
		<td width=320 height=24>
			<font size=2><%=order.getORDER_TRADE_PAYER() %></font>
		</td>
	</tr>
	<tr>
		<td style="font-family: Tahoma; font-size: 8pt;" width=200 height=24
			bgcolor="f7f7f7">주문 상태 :</td>
		<td width=320 height=24>
		<select name="status">
			<option value="0" <%if(order.getORDER_STATUS()==0){%> selected
				<%}%>>대기중</option>
			<option value="1" <%if(order.getORDER_STATUS()==1){%> selected
				<%}%>>발송 준비</option>
			<option value="2" <%if(order.getORDER_STATUS()==2){%> selected
				<%}%>>발송 완료</option>
			<option value="3" <%if(order.getORDER_STATUS()==3){%> selected
				<%}%>>배송중</option>
			<option value="4" <%if(order.getORDER_STATUS()==4){%> selected
				<%}%>>배송 완료</option>
			<option value="5" <%if(order.getORDER_STATUS()==5){%> selected
				<%}%>>주문 취소</option>
		</select>
		</td>
	</tr>
	<tr><td style="background-color: #F0F0F0; height: 1px;" colspan=6></tr>
	<tr><td style="background-color: #F0F0F0; height: 1px;" colspan=6></tr>
	<tr>
		<td align=center style="background-color: #F0F0F0; height: 1px;"
			colspan=6>
			<input type=submit value="수정">&nbsp; 
			<input type=button
			onclick="javascript:location.href('./AdminOrderList.ao')"
			value="취소">
		</td>
	</tr>
</table>
</form>
<!-- 주문 정보 수정 -->
</td>
</tr>
</table>
</body>
</html>