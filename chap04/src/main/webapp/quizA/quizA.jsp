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
			���̵� <input type="text" name="user_id"/>
			��й�ȣ <input type="password" name="user_pwd" />
			<button type="submit">�α���</button>
		</form>
		<button onclick="location.href='./register.jsp';">ȸ������</button>
	</div>
	<% } else { %>
	
	<div>
		���� �α��� ���Դϴ�
		<ul>
			<% 
				
				java.util.List<String> memo_list = MemoAddServlet.memos.get(session.getAttribute("user")); 
			%>
			
			<% 
				if (memo_list != null)
				if (memo_list.size() == 0) { %>
			<li>�޸� ���� �����ϴ�</li>
			<% } else { 
					for (String memo : memo_list) {
			%>
						<li><%=memo %></li>
			<% 		}
				}%>
			
		</ul>
		
		<h5>�޸� �߰�</h5>
		
		<form action="./memo/add" method="POST">
			<input type="text" name="memo"/> <input type="submit" value="add" />
		</form>
	</div>
	<% } %>
	
</body>
</html>