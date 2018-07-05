<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="net.basket.db.*"%>
<%@ page import="net.goods.db.*" %>

<%
	List basketList = (ArrayList) request.getAttribute("basketlist");
	List goodsList = (ArrayList) request.getAttribute("goodslist");
	
	String item = request.getParameter("item");
	String gr_goods_num = request.getParameter("gr_goods_num");
	String isitem = request.getParameter("isitem");
%>

<html>
<head>
<title>쇼핑몰</title>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	align="center">
	<tr>
		<td colspan=2><!-- 장바구니 -->
		<p align="center">
		<form action="./OrderStart.or" name="basketform" method="post">
		<input type="hidden" name="order" value="basket">
		<table width="80%">
			<tr align=center>
				<td><b>장 바 구 니</b></td>
			</tr>
		</table>
		<table width="80%" cellpadding="0" cellspacing="0">
			<tr height=26 bgcolor="94d7e7">
				<td height="3" colspan="7" align=right></td>
			</tr>
			<tr bgcolor="#f0f8ff" align="center">
				<td width="5%"><font size="2">번호</font></td>
				<td width="5%"><font size="2">사진</font></td>
				<td width="25%"><font size="2">제품명</font></td>
				<td width="8%"><font size="2">수량</font></td>
				<td width="8%"><font size="2">가격</font></td>
				<td width="8%"><font size="2">취소</font></td>
			</tr>
			<%
			if (basketList != null && basketList.size() != 0) {
				for (int i = 0; i < basketList.size(); i++) {
					BasketBean dto = (BasketBean) basketList.get(i);
					GoodsBean goods=(GoodsBean) goodsList.get(i);
			%>
			<tr align="center">
			<td><font size="2"><%=dto.getBASKET_NUM()%></font></td>
			<td><font size="2"><img src="./upload/<%=goods.getGOODS_IMAGE().split(",")[0] %>" 
														width=50 height=50></font></td>
			<td><font size="2"><%=goods.getGOODS_NAME()%></font></td>
			<td><font size="2"><%=dto.getBASKET_GOODS_AMOUNT()%></font></td>
			<td><font size="2"><%=goods.getGOODS_PRICE()%></font></td>
			<td><font size="2"><a href="BasketDelete.ba?num=<%=dto.getBASKET_NUM()%>"
														onclick="return confirm('취소하시겠습니까?')">취소</a>
			</font></td>
			</tr>
			<%
				}
			}else{
			%>
			<tr>
			<td colspan="7" align="center">
				<font size="2">장바구니에 담긴 상품이 없습니다.</font>
			</td>
			</tr>
			<%
			}
			%>
		</table>
		
		<table width="80%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="2" bgcolor="94d7e7"></td>
			</tr>
		</table>
		<br>
		
		<table width="80%" cellpadding="0" cellspacing="0">
			<tr>
			<td align="center">
			<%
			if (basketList != null && basketList.size() != 0) {
			%>
			<a href="javascript:basketform.submit()">[구매하기]</a>
			<%}else{%>
			<a href="#" onclick="javascript:alert('주문할 상품이 없습니다.')">[구매하기]</a>
			<%}
			if (item == null) {%>
				<a href="./GoodsList.go?item=new_item">[계속 쇼핑하기]</a>
			<%}else{%>
				<a href="./Goods_Detail.go?item=<%=item %>&gr_goods_num=<%=gr_goods_num %>
					&isitem=<%=isitem %>">[계속 쇼핑하기]</a>
			<%}%>
			</td>
			</tr>
		</table>
		</form>
		<!-- 장바구니 -->
		</p>
		</td>
	</tr>
</table>
</body>
</html>