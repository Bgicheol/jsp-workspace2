<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="styleSheet" href="./post.css"/>
</head>
<body>
	<form action="./main" method="GET">
			<div id="user">���̵�: <input type="text" value="���̵�" style="width:100px"/></div>
			
			<div id="password">��й�ȣ: <input type="password" placeholder="��й�ȣ" style="width: 100px" /></div>
			
		<div id="main">
			<div id="title">���� :</div> 
			<div id="titleText">
				<input type="text" value="�����Է�" style="width:780px"/>
			</div> <br>
			<div id="post">���� : </div>
			<div id="textarea">
				<textarea cols="109" rows= "30" style="resize:none;"></textarea>
			</div>
			<div id="btn">
				<button type="submit" class="save">����</button>
				<button class="edit">����</button>
				<button class="delete">����</button>
			</div>
		</div>
	</form>
</body>
</html>