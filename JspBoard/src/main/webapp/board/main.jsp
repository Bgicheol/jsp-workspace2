<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	
	<div id="postNumber">글 번호</div>
	<div id="posttitle">제목</div>
	<div id="writer">글쓴이</div>
	<div id="views">조회수</div>		
	
	<div id="page">
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
	<button id="write" onclick="location.href='./post.jsp'">글쓰기</button>
 </div>
	
</body>
</html>