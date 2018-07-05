<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="net.member.db.MemberBean"%>
<%@ page import="net.basket.db.BasketBean"%>
<%@ page import="net.goods.db.GoodsBean" %>
<%
	MemberBean member = (MemberBean) request.getAttribute("member");
	String ordertype = (String) request.getAttribute("ordertype");
	List orderinfo = null;
	List basketlist = null;
	List goodslist=null;
	
	if (ordertype.equals("goods")) {
		orderinfo = (ArrayList) request.getAttribute("orderinfo");
	} else {
		basketlist = (ArrayList) request.getAttribute("basketlist");
		goodslist = (ArrayList) request.getAttribute("goodslist");
	}
%>
<html>
<head>
<title>쇼핑몰</title>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	align="center">
<tr>
	<td colspan=2 align=right>
	<!-- 주문 페이지 -->
	<form action="./OrderAdd.or" method="post" name="orderform">
	<input type="hidden" name="ordertype" value="<%=ordertype%>"> 
	<%if (ordertype.equals("goods")) {%>
		<input type="hidden" name="goodsnum" value="<%=orderinfo.get(0)%>">
		<input type="hidden" name="goodsname" value="<%=orderinfo.get(1)%>">
		<input type="hidden" name="goodsamount" value="<%=orderinfo.get(2)%>">
		<input type="hidden" name="goodscolor" value="<%=orderinfo.get(3)%>">
		<input type="hidden" name="goodssize" value="<%=orderinfo.get(4)%>">
		<input type="hidden" name="goodsprice" value="<%=orderinfo.get(5)%>">
	<%}%>
	<input type="hidden" name="memberid" value="<%=member.getMEMBER_ID() %>">
	
	<!-- 주문 상세내역 -->
	<table border=0 cellspacing=1 cellpadding=0 width=80%>
		<tr>
			<p align=left><b><font size=2>주문 상세내역</font></b></p>
		</tr>
		
		<tr align=center height=20>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">사진</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">상품명</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">수량</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">색깔</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">사이즈</td>
		<td style="font-family: Tahoma; font-size: 8pt; font-weight: bold;">가격</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<%
			if (ordertype.equals("goods")) {
		%>
		<tr align=center height=20>
		<td style="font-family: Tahoma; font-size: 7pt;">
			<img src="./upload/<%=orderinfo.get(6) %>" width=50 height=50></td>
		<td style="font-family: Tahoma; font-size: 8pt;"><%=orderinfo.get(1)%></td>
		<td style="font-family: Tahoma; font-size: 8pt;"><%=orderinfo.get(2)%></td>
		<td style="font-family: Tahoma; font-size: 8pt;"><%=orderinfo.get(3)%></td>
		<td style="font-family: Tahoma; font-size: 8pt;"><%=orderinfo.get(4)%></td>
		<td style="font-family: Tahoma; font-size: 8pt;"><%=orderinfo.get(5)%></td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<%
			} else {
				for (int i = 0; i < basketlist.size(); i++) {
					BasketBean basket = (BasketBean) basketlist.get(i);
					GoodsBean goods = (GoodsBean) goodslist.get(i);
		%>
		<tr align=center height=20>
		<td style="font-family: Tahoma; font-size: 7pt;">
			<img src="./upload/<%=goods.getGOODS_IMAGE().split(",")[0] %>" 
				width=50 height=50>
		</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=goods.getGOODS_NAME()%>
		</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=basket.getBASKET_GOODS_AMOUNT()%>
		</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=basket.getBASKET_GOODS_COLOR()%>
		</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=basket.getBASKET_GOODS_SIZE()%>
		</td>
		<td style="font-family: Tahoma; font-size: 8pt;">
			<%=goods.getGOODS_PRICE()%>
		</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<%
				}
			}
		%>
	</table>

	<table width=80% border=0 cellpadding="0" cellspacing="1">
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td><b><font size=2>주문자 정보</font></b></td>
		</tr>
		<tr>
			<td style="font-family: Tahoma; font-size: 8pt;" width=80 height=24
				bgcolor="f7f7f7">이름</td>
			<td width=320 height=24>
				<font size=2><%=member.getMEMBER_NAME()%></font>
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr>
			<td style="font-family: Tahoma; font-size: 8pt;" height=24
				bgcolor="f7f7f7">휴대폰</td>
			<td width=320 height=24>
				<font size=2><%=member.getMEMBER_MOBILE()%></font>
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr>
			<td style="font-family: Tahoma; font-size: 8pt;" height=24
				bgcolor="f7f7f7">이메일 주소</td>
			<td width=320 height=24>
				<font size=2><%=member.getMEMBER_EMAIL()%></font>
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
	</table>

	<table width=80% border=0 cellpadding="0" cellspacing="1">
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td><b><font size=2>배송지 정보</font></b></td>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">받는사람</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_NAME" size=12
				value="<%=member.getMEMBER_NAME() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=23>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">집 전화</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_PHONE" size=15
				value="<%=member.getMEMBER_PHONE() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">휴대폰</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_MOBILE" size=15
				value="<%=member.getMEMBER_MOBILE() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">배송지 우편번호</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_ZIPCODE" size=7
				value="<%=member.getMEMBER_ZIPCODE() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">배송지 주소</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_ADDR1" size=50
				value="<%=member.getMEMBER_ADDR1() %>"></td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">배송지 나머지 주소</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
				<input type="text" name="ORDER_RECEIVE_ADDR2" size=50
				value="<%=member.getMEMBER_ADDR2() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr height=20>
			<td style="font-family: Tahoma; font-size: 8pt;" width=130 height=24
				bgcolor="f7f7f7">기타 요구사항</td>
			<td style="font-family: Tahoma; font-size: 8pt;">
			<textarea name="ORDER_MEMO" cols=60 rows=12></textarea>
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
	</table>

	<table width=80% border=0 cellpadding="0" cellspacing="1">
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td height=10>
			<td>
		</tr>
		<tr>
			<td><b><font size=2>결제 정보</font></b></td>
		</tr>
		<tr>
			<td style="font-family: Tahoma; font-size: 8pt;" width=200 height=24
				bgcolor="f7f7f7">입금자명(온라인입금일 경우) :</td>
			<td width=320 height=24>
			<input type="text" name="ORDER_TRADE_PAYER"
				size=20 value="<%=member.getMEMBER_NAME() %>">
			</td>
		</tr>
		<tr>
			<td style="background-color: #F0F0F0; height: 1px;" colspan=6>
		</tr>
		<tr>
			<td align=center style="background-color: #F0F0F0; height: 1px;"
				colspan=6>
				<input type=submit value="주문">&nbsp;
				<input type=button value="취소">
			</td>
		</tr>
	</table>
	</form>
	<!-- 주문 페이지 -->
	</td>
</tr>
</table>
</body>
</html>