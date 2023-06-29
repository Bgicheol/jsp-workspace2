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
			<div id="user">아이디: <input type="text" value="아이디" style="width:100px"/></div>
			
			<div id="password">비밀번호: <input type="password" placeholder="비밀번호" style="width: 100px" /></div>
			
		<div id="main">
			<div id="title">제목 :</div> 
			<div id="titleText">
				<input type="text" value="제목입력" style="width:780px"/>
			</div> <br>
			<div id="post">내용 : </div>
			<div id="textarea">
				<textarea cols="109" rows= "30" style="resize:none;"></textarea>
			</div>
			<div id="btn">
				<button type="submit" class="save">저장</button>
				<button class="edit">수정</button>
				<button class="delete">삭제</button>
			</div>
		</div>
	</form>
</body>
</html>