<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="vo.Cart"%>
<%@page import="vo.Dog"%>
<%@page import="dao.DogDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
   width: 640px;
   border: 1px red solid;
   margin: auto;
   
}

h2 {
   text-align: center;
}

table {
   width: 550px;
   margin: auto;
}

.tr_top {
   background-color: lime;
}

.div_empty {
   text-align: center;
   background-color:
}

.td_command {
   text-align: right;
}
#todayImageList{
   text-align: center;
}
#productImage{
   width:150px;
   height:150px;
   border:none;
}
#cartImage{
   width:70px;
   height:70px;
   border:none;
}
#select{
	text-align: right;
}
#commandList{
	text-align: center;
}
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}
</style>
<script>
	function checkAll(theForm){
		if(theForm.remove.length == undefined){
			theForm.remove.checked = theForm.allCheck.checked;
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
	
	function checkQty(kind,qty){
		if(qty != 1){
			location.href="dogCartQtyDown.dog?kind="+ encodeURIComponent(kind);
		}
	}
</script>
</head>
<body>
<c:if test="${startMoney !=null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>
<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>
<section id="listForm">
	<c:if test="${cartList !=null && cartList.size()>0 }">
   <h2>장바구니 목록</h2>
<form method="post">
      <table>
    	<tr id="select">
    		<td colspan="6">
    		<select id = "startMoney" name="startMoney">
    			<option>=최하=</option>
    			<c:choose>
    				<c:when test="${startMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<select id = "endMoney" name="endMoney">
    			<option>=최고=</option>
    			<c:choose>
    				<c:when test="${endMoney==1000 }">
    					<option selected="selected">1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==2000 }">
    					<option>1000</option>
    					<option selected="selected">2000</option>
    					<option>3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==3000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option selected="selected">3000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${endMoney==4000 }">
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
	    				<option selected="selected">4000</option>
    				</c:when>
    				<c:otherwise>
    					<option>1000</option>
    					<option>2000</option>
    					<option>3000</option>
    					<option>4000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<input type="submit" value="검색" formaction="dogCartSearch.dog"/>
    		</td>
    	</tr>
        <tr class = "tr_top">
        	<td><input type="checkbox" id = "allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td>
             <td>번호</td>
             <td>상품 이미지</td>
             <td>상품명</td>
             <td>가격</td>
             <td>수량</td>
         </tr>

        <c:forEach var="cart" items="${cartList }" varStatus="status">
        
        <tr>
        	<td>
        		<input type="checkbox" id="remove" name="remove" value="${cart.kind }"/>
        	</td>
             <td>
             
             ${status.index+1}<!-- 번호값계산 -->
            </td>
             <td>
             <img src = "images/${cart.image }" id ="cartImage"/>
            </td>
             <td>
             ${cart.kind }
            </td>
             <td>
             ${cart.price }
            </td>
             <td>
             <a href="dogCartQtyUp.dog?kind=${cart.encodingKind }">
             <img src="images/up.jpg" id = "upImage" border=0/>
             </a><br>
             ${cart.qty }<br>
             <a href="javascript:checkQty('${cart.kind}',${cart.qty})">
             <img src="images/down.jpg" id = "downImage" border=0/>
             </a>
            </td>
         </tr>
        </c:forEach>
      <tr>
         <td colspan="5" style="text-align:center;">
            총 금액 : ${totalMoney}원
         </td>
      </tr>
      <tr>
         <td colspan="5" style="text-align:center;">
         	<input type="submit" value="삭제" formaction="dogCartRemove.dog"/>
         </td>
      </tr>
      </table>
</form>
	</c:if>
	<c:if test="${cartList == null }">
      <section class="div_empty">
      개정보가 없습니다.
      </section>
	</c:if>
   <nav id="commandList">
   		<a href="dogList.dog">쇼핑 계속하기</a>
   </nav>
   
</section>
</body>
</html> 