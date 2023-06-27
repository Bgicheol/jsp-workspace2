<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// ��� ��û�� Ŭ�󸮾�Ʈ�� ������ ���� �Բ� �����´�
	Cookie[] cookies = request.getCookies();
	
	// EL/JSTL�� �ݺ����� Ȱ���ϱ� ���� ��Ʈ����Ʈ�� ���
	pageContext.setAttribute("cookies", cookies);
	// f12 ��Ʈ��ũ ����ʿ� �Ƿ�����.
 	for (Cookie cookie : cookies) {
		System.out.println(cookie.getName() + "=" + cookie.getValue());
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Cookie List</title>
</head>
<body>

	<h3># Cookies</h3>
	
	<ul>
		<li>${cookie.myname.value}</li> <!-- ����� path�� ��Ű�� �켱������ ������ -->
		<li>${cookie.mainfood.value}</li>
		<li>${cookie.JSESSIONID.name}=${cookie.JSESSIONID.value}</li>
		<li>${cookie.age.value}</li>
	</ul>
	<!--c:forEach: Getter�� �޸� Object��� ������ Ȱ���� �� �ִٴ� ������ �ִ� -->
	<div style="display: grid; grid-template-columns:1fr 100px;">
	<c:forEach items="${cookies}" var="cook">
		<div>
			${cook.name}=${cook.value}(${cook.path}) <!-- path�� �������� �ʾƼ� path�� ����°� �ȵ� -->
		</div>
		<div>
			<a href="./delete.jsp?name=${cook.name}">[����]</a>
		</div>
	</c:forEach>
	</div>
</body>
</html>