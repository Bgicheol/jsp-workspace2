<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="jspBoard.model.BoardModel" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 메인 화면</title>
<link rel="styleSheet" href="./JspBoard.css"/>
</head>
<body>
 <div id="board">
	<div id="title"><p>JSP 연습</p></div>	
<!-- 
	<div id="postNumber">글 번호</div>
	<div id="posttitle">제목</div>
	<div id="writer">글쓴이</div>
	<div id="views">조회수</div>		
	
 -->
 	<form action="./post.jsp" method="POST">
	<div id="header">
		<table id="header">
			<tr>
				<td id="postNumber">글 번호</td>
				<td id="posttitle">제목</td>
				<td id="writer">글쓴이</td>
				<td id="views">조회수</td>
			</tr>
				<c:forEach items="${list}" var="model">
					<tr>
						<td>${model.getPost_number()}</td>
						<td>${model.getTitle()}</td>
						<td>${model.getWriter()}</td>
						<td>${model.getViews()}</td>
					</tr>
				</c:forEach>
			
		</table>
	</div>
	<div id="footer">
		<table>
			<tr>
				<td>&lt; </td>
				<td>1/</td>
				<td>2/</td>
				<td>3/</td>
				<td>4/</td>
				<td>5</td>
				<td> &gt;</td>
			</tr>
		</table>		
	</div>
	
	<button id="write" type="submit">글쓰기</button>
	
 	</form>
	 </div>
	
</body>
</html>