<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	
	<div id="postNumber">�� ��ȣ</div>
	<div id="posttitle">����</div>
	<div id="writer">�۾���</div>
	<div id="views">��ȸ��</div>		
	
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
	<button id="write" onclick="location.href='./post.jsp'">�۾���</button>
 </div>
	
</body>
</html>