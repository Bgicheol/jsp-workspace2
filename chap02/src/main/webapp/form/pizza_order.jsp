<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String dough = request.getParameter("dough");
	String[] topings = request.getParameterValues("toping");
	String sauce = request.getParameter("sauce");
	String cheese = request.getParameter("cheese");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>피자 주문 확인</title>
</head>
<body>
	<h1>피자 주문서</h1>
	
	<p>
		선택한 피자 옵션 <br>
		도우 :<%= dough %> <br>
		소스 :<%= sauce %> <br>	
		토핑 :<%
				if (topings != null){
					for (String toping : topings) {
						out.print(toping + ", ");
					};
				}
			%> <br>
		치즈 :<%=cheese %>
		
		
	</p>
</body>
</html>