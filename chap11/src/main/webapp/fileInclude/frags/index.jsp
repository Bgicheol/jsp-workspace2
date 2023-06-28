<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Fragment Included</title>
<style>
#grid-container {
	display:grid;
	grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
	row-gap: 5px;
	column-gap: 5px;
	
}

#grid-container > div {
	border: solid 1px black;
}

.tfooter {
	grid-column: 1 / 6; 
}

</style>
</head>
<body>

<c:set var="message" value="I am a message from index.jsp" scope="page"/>

	<div id="grid-container">
		<!-- <jsp:includ page로 진행하면 taglib이 작동안함-->
		<%@ include file="./thead.jsp" %>
		<%@ include file="./tbody.jsp" %>
	</div>
</body>
</html>