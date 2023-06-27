<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap04.quiz.MemoAddServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>quizA</title>
</head>
<body>
	<hr>
	
	
	<% if (session.getAttribute("user") == null){%>
	<div>
		<form action="./login" method="POST">
			아이디 <input type="text" name="user_id"/>
			비밀번호 <input type="password" name="user_pwd" />
			<button type="submit">로그인</button>
		</form>
		<button onclick="location.href='./register.jsp';">회원가입</button>
	</div>
	<% } else { %>
	
	<div>
		현재 로그인 중입니다
		<ul>
			<% 
				
				java.util.List<String> memo_list = MemoAddServlet.memos.get(session.getAttribute("user")); 
			%>
			
			<% 
				if (memo_list != null)
				if (memo_list.size() == 0) { %>
			<li>메모가 아직 없습니다</li>
			<% } else { 
					for (String memo : memo_list) {
			%>
						<li><%=memo %></li>
			<% 		}
				}%>
			
		</ul>
		
		<h5>메모 추가</h5>
		
		<form action="./memo/add" method="POST">
			<input type="text" name="memo"/> <input type="submit" value="add" />
		</form>
	</div>
	<% } %>
	
</body>
</html>