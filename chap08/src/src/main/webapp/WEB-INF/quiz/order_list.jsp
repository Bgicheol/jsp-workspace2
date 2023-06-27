<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap08.model.Order_info, java.util.List"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �ֹ� ����Ʈ</title>
</head>
<body>
	
	<!-- /contextPath/pizza/order/all�� ���� -->

	<h3>��� �ֹ����� ������</h3>

	<!--  ���⿡ ��� �ֹ��� ������ ���ּ��� (�ݺ��� �ݵ�� JSTL���) -->
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