<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 모든 요청은 클라리언트에 보관된 쿠리를 함께 가져온다
	Cookie[] cookies = request.getCookies();
	
	// EL/JSTL의 반복문을 활용하기 위해 어트리뷰트에 등록
	pageContext.setAttribute("cookies", cookies);
	// f12 네트워크 헤더쪽에 실려있음.
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
		<li>${cookie.myname.value}</li> <!-- 가까운 path의 쿠키를 우선적으로 꺼낸다 -->
		<li>${cookie.mainfood.value}</li>
		<li>${cookie.JSESSIONID.name}=${cookie.JSESSIONID.value}</li>
		<li>${cookie.age.value}</li>
	</ul>
	<!--c:forEach: Getter가 달린 Object라면 무조건 활용할 수 있다는 장점이 있다 -->
	<div style="display: grid; grid-template-columns:1fr 100px;">
	<c:forEach items="${cookies}" var="cook">
		<div>
			${cook.name}=${cook.value}(${cook.path}) <!-- path는 딸려오지 않아서 path로 지우는건 안됨 -->
		</div>
		<div>
			<a href="./delete.jsp?name=${cook.name}">[삭제]</a>
		</div>
	</c:forEach>
	</div>
</body>
</html>