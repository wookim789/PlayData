<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>

<html>
<head>
<title>JSTL fmt 라이브러리 사용 예제</title>
</head>
<body>

<%-- <fmt:setLocale value="en_US"/> --%>
<fmt:setLocale value="ko_KR"/>
<fmt:bundle basename="test">
	<fmt:message key="name"/><br>
	<fmt:message key="say"/><br>
	<fmt:message key="say2">
		<fmt:param value="고길동"/>
	</fmt:message>
</fmt:bundle>

<p>
<fmt:formatNumber value="50000" type="currency"/><br>
<fmt:formatNumber value="0.15" type="percent"/><br>
<fmt:formatNumber value="500567300" pattern="###,###,###"/><p>

<fmt:formatDate value="${date}" type="date"/><br>
<fmt:formatDate value="${date}" type="time"/><br>
<fmt:formatDate value="${date}" type="both"/><p>

<fmt:formatDate value="${date}" type="both" timeStyle="short" dateStyle="short"/><br>
<fmt:formatDate value="${date}" type="both" timeStyle="long" dateStyle="long"/><br>

</body>
</html>
