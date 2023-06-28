<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>\
<%@ page import="jspBoard.model.BoardModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���� ȭ��</title>
<link rel="styleSheet" href="./JspBoard.css"/>
</head>
<body>
 <div id="board">
	<div id="title"><p>JSP ����</p></div>	
<!-- 
	<div id="postNumber">�� ��ȣ</div>
	<div id="posttitle">����</div>
	<div id="writer">�۾���</div>
	<div id="views">��ȸ��</div>		
	
 -->
	<div id="header">
		<table id="header">
			<tr>
				<td id="postNumber">�� ��ȣ</td>
				<td id="posttitle">����</td>
				<td id="writer">�۾���</td>
				<td id="views">��ȸ��</td>
			</tr>
			<%for(BoardModel model: request.getAttribute("writer")){ %>
				<tr>
					<td><%=model.getPost_number()%></td>
					<td><%=model.getTitle() %></td>
					<td><%=model.getWriter() %></td>
					<td><%=model.getViews() %></td>
				</tr>
			<%} %>
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
	
	<button id="write" type="submit">�۾���</button>
 </div>
	
</body>
</html>