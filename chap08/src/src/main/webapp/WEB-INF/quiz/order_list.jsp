<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap08.model.Order_info, java.util.List"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 주문 리스트</title>
</head>
<body>
	
	<!-- /contextPath/pizza/order/all로 접속 -->

	<h3>모든 주문보기 페이지</h3>

	<!--  여기에 모든 주문이 나오게 해주세요 (반복은 반드시 JSTL사용) -->
	<form action="/all">
		
		<c:forEach items="${orders}" var="order" >
			<div id="${order.order_id}">${order.order_id}</div>
			<div id="${order.address }">${order.address }</div>
			<div id="${order.pizza_name }">${order.pizza_name }</div>
			<div id="${order.pizza_price }">${order.pizza_price }</div>
			
		</c:forEach>
	</form>	
</body>
</html>