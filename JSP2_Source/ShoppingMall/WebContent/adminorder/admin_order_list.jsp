<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="net.order.db.*" %>
<%@ page import="java.util.*" %>
<%
	List orderlist=(List)request.getAttribute("orderlist");
	int ordercount=((Integer)request.getAttribute("ordercount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<html>
<head>
<title>쇼핑몰</title>
</head>
<body>
<table width="960" cellspacing="0" cellpadding="0" border="0" align="center">
<tr>
<td colspan=2 align=center>
<table border=0 cellspacing=1 cellpadding=0 width=80%>
	<tr>
	<td align=right colspan=10 height=25 colspan=2 style=font-family:Tahoma;font-size:8pt;>
	전체 주문 수 : <b><%=ordercount %></b> 개&nbsp;&nbsp;&nbsp;
	</td>
	</tr>
	<tr align=center height=20>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>주문번호</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>주문자</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>결제방법</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>주문금액</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>주문상태</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>주문일시</td>
	  <td style=font-family:Tahoma;font-size:8pt;font-weight:bold;>수정/삭제</td>
	</tr>
	<tr>
		<td style="background-color:#F0F0F0; height:1px;" colspan=6>
	</tr>
	<%for(int i=0;i<orderlist.size();i++){ 
		OrderBean order=new OrderBean();
		order=(OrderBean)orderlist.get(i); %>
	<tr align=center height=20>
	<td style=font-family:Tahoma;font-size:7pt;><%=order.getORDER_TRADE_NUM()%></td>
	<td style=font-family:Tahoma;font-size:8pt;><%=order.getORDER_MEMBER_ID()%></td>
	<td style=font-family:Tahoma;font-size:8pt;><%=order.getORDER_TRADE_TYPE()%></td>
	<td style=font-family:Tahoma;font-size:8pt;><%=order.getORDER_SUM_MONEY()%></td>
	<td style=font-family:Tahoma;font-size:8pt;>
   		<%if(order.getORDER_STATUS()==0){ %>
   			대기중
   		<%}else if(order.getORDER_STATUS()==1){ %>
   			발송준비
   		<%}else if(order.getORDER_STATUS()==2){ %>
   			발송완료
   		<%}else if(order.getORDER_STATUS()==3){ %>
   			배송중
   		<%}else if(order.getORDER_STATUS()==4){ %>
   			배송완료
   		<%}else if(order.getORDER_STATUS()==5){ %>
   			주문취소
   		<%} %>
   	</td>
   	<td style=font-family:Tahoma;font-size:8pt;><%=order.getORDER_DATE()%></td>
   	<td style=font-family:Tahoma;font-size:8pt;>
   	<a href="./AdminOrderDetail.ao?num=<%=order.getORDER_NUM() %>">
   	Modify</a>/
   	<a href="./AdminOrderDelete.ao?num=<%=order.getORDER_NUM() %>" 
   		onclick="return confirm('삭제하시겠습니까?')">Delete</a>
   	</td>
	</tr>
	<tr>
		<td style="background-color:#F0F0F0; height:1px;" colspan=6>
	</tr>
	<%} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>[이전]&nbsp;
			<%}else{ %>
			<a href="./AdminOrderList.ao?page=<%=nowpage-1 %>">
			[이전]</a>&nbsp;
			<%}%>
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>[<%=a%>]
				<%}else{ %>
					<a href="./AdminOrderList.ao?page=<%=a %>">
					[<%=a %>]
					</a>&nbsp;
				<%} %>
			<%} %>
			<%if(nowpage>=maxpage){ %>[다음]
			<%}else{ %>
			<a href="./AdminOrderList.ao?page=<%=nowpage+1 %>">[다음]</a>
			<%} %>
		</td>
	</tr>
</table>
</td>
</tr>	
</table>
</body>
</html>