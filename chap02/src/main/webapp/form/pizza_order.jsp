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
<title>���� �ֹ� Ȯ��</title>
</head>
<body>
	<h1>���� �ֹ���</h1>
	
	<p>
		������ ���� �ɼ� <br>
		���� :<%= dough %> <br>
		�ҽ� :<%= sauce %> <br>	
		���� :<%
				if (topings != null){
					for (String toping : topings) {
						out.print(toping + ", ");
					};
				}
			%> <br>
		ġ�� :<%=cheese %>
		
		
	</p>
</body>
</html>