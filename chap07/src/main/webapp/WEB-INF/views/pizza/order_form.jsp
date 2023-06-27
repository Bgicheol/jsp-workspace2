<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap07.model.Pizza, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 주문 페이지</title>
</head>
<body>
	
	<h1>피자를 주문하세요</h1>
		<!-- get으로 오면 ./order로  POST로 오면 post 방식으로 보냄 -->
	<form action="./order" method="POST">
		고객ID : <input type="text" name="customer_id" value="CUS123" readOnly/>
		<select name="pizza_id">
		<% for (Pizza pizza : (List<Pizza>)request.getAttribute("pizzas")) { %>
			<option value="<%=pizza.getPizza_id()%>"><%=pizza.getPizza_name()%></option>
			
		<% } %>
		</select> <br>
		주소 : <input type="text" name="address" size="50"/> <br>
		추가 옵션 :
		<input id="extra_cheese" type="radio" name="pizza_option" value="111" checked/> 치즈추가 
		<label for="extra_cheese">치즈추가</label> <br>
		<input id="extra_pine" type="radio" name="pizza_option" value="112" /> 파인애플 추가 
		<label for="extra_pine">파인애플 추가</label> <br>
		<input id="extra_hub" type="radio" name="pizza_option" value="113" /> 허브 추가 
		<label for="extra_hub">허브 추가</label> <br>
		<input type="submit" value="주문하기">
	</form>
</body>
</html>