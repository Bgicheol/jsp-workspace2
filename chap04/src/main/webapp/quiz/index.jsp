<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
</head>
<body>
	
	<h3># Quiz의 요구사항</h3>
	
	<ul>
		<li>아이디와 비밀번호를 입력하면 로그인을 할 수 있다</li>
		<li>회원가입은 아이디와 비밀번호만 입력하면 완료된다 (아이디 중복은 체크해야함)</li>
		<li>로그인에 성공하고 나면 세션이 유지되는 한 로그인은 유지되어야 한다</li>
		<li>로그인 한 사람은 새로운 메모를 등록할 수 있고, 예전에 등록했던 메모들도 볼 수 있다</li>
		<li>서버를 종료했을 때 모든 회원이 사라져도 회원 및 메모가 사라져도 상관없다</li>
		<li>페이지 개수에 제한은 없고 모든 내용은 퀴즈 폴더 밑에 만들어 둘 것
		 	(서블릿은 quiz 패키지에 둘 것)</li>
	</ul>
</body>
</html>