<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap07.model.Pizza, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �ֹ� ������</title>
</head>
<body>
	
	<h1>���ڸ� �ֹ��ϼ���</h1>
		<!-- get���� ���� ./order��  POST�� ���� post ������� ���� -->
	<form action="./order" method="POST">
		��ID : <input type="text" name="customer_id" value="CUS123" readOnly/>
		<select name="pizza_id">
		<% for (Pizza pizza : (List<Pizza>)request.getAttribute("pizzas")) { %>
			<option value="<%=pizza.getPizza_id()%>"><%=pizza.getPizza_name()%></option>
			
		<% } %>
		</select> <br>
		�ּ� : <input type="text" name="address" size="50"/> <br>
		�߰� �ɼ� :
		<input id="extra_cheese" type="radio" name="pizza_option" value="111" checked/> ġ���߰� 
		<label for="extra_cheese">ġ���߰�</label> <br>
		<input id="extra_pine" type="radio" name="pizza_option" value="112" /> ���ξ��� �߰� 
		<label for="extra_pine">���ξ��� �߰�</label> <br>
		<input id="extra_hub" type="radio" name="pizza_option" value="113" /> ��� �߰� 
		<label for="extra_hub">��� �߰�</label> <br>
		<input type="submit" value="�ֹ��ϱ�">
	</form>
</body>
</html>