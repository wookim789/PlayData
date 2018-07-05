<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="net.order.db.*"%>
<%
	String id=(String)session.getAttribute("id");
	List goods_order_list=(List)request.getAttribute("goods_order_list");
	int ordercount=((Integer)request.getAttribute("ordercount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
	int totalmoney=((Integer)request.getAttribute("totalmoney")).intValue();
%>
<html>
<head>
<title>쇼핑몰</title>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0"
	align="center">
<tr>
<td colspan=2>
<!-- 회원의 주문내역 보기 -->
<table width="700" border="0" align="center">
<tr>
	<td>현재 (<%=id%>)고객님께서 주문하신 내역이 총 (<%=ordercount%>)개 있습니다.</td>
</tr>
<tr>
	<td height="62" align="center" valign="middle">
	<table width="700" border="1" cellspacing="0" cellpadding="0"
		bordercolor="#CCCCCC">
		<tr>
			<td height="20"><div align="center">상품명</div></td>
			<td><div align="center">색상/사이즈</div>	</td>
			<td><div align="center">수량</div></td>
			<td><div align="center">총 금액</div></td>
			<td><div align="center">주문 상태</div></td>
			<td><div align="center">주문 날짜</div></td>
		</tr>
		<%
		if (goods_order_list.size() == 0) {
		%>
		<td align=center colspan=6>주문 내역이 없습니다.</td>
		<%
		}
		
		for (int i = 0; i < goods_order_list.size(); i++) {
			OrderBean order = new OrderBean();
			order = (OrderBean) goods_order_list.get(i);
		%>
		<tr align=center>
			<td height="20"><%=order.getORDER_GOODS_NAME()%></td>
			<td>
				<%=order.getORDER_GOODS_COLOR()%>/
				<%=order.getORDER_GOODS_SIZE()%>
			</td>
			<td><%=order.getORDER_GOODS_AMOUNT()%></td>
			<td><%=order.getORDER_SUM_MONEY()%></td>
			<td>
			<%if (order.getORDER_STATUS() == 0) {%>대기중
			<%}else if (order.getORDER_STATUS() == 1){%>발송준비
			<%}else if (order.getORDER_STATUS() == 2){%>발송완료
			<%}else if (order.getORDER_STATUS() == 3){%>배송중
			<%}else if (order.getORDER_STATUS() == 4){%>배송완료
			<%}else if (order.getORDER_STATUS() == 5){%>주문취소
			<%}%>
			</td>
			<td><%=order.getORDER_DATE()%></td>
		</tr>
		<%
			}
		%>
		<tr align=center height=20>
			<td colspan=7 style="font-family: Tahoma; font-size: 10pt;">
			<%if (nowpage <= 1) {%>
			[이전]&nbsp;
			<%}else{%>
			<a href="./OrderList.or?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%}%>
			<%
			for (int a = startpage; a <= endpage; a++) {
				if (a == nowpage) {
			%>
			[<%=a%>]
			<%
				}else{
			%>
			<a href="./OrderList.or?page=<%=a %>">[<%=a%>]</a>&nbsp;
			<%	}
			}
			%>
			<%if (nowpage >= maxpage) {%>
			[다음]
			<%}else{%>
			<a href="./OrderList.or?page=<%=nowpage+1 %>">[다음]</a>
			<%}%>
			</td>
		</tr>
	</table>
	</td>
</tr>
<tr>
	<td height="28">
	<div align="right">총 주문금액 : <%=totalmoney%>원</div>
	</td>
</tr>
</table>
<!-- 회원의 주문내역 보기 -->
</td>
</tr>
</table>
</body>
</html>