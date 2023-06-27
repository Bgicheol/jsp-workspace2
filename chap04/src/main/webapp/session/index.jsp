<%@page import="java.util.Enumeration, java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session</title>
</head>
<body>
	
	<h3># Http Session</h3>
	
	<ol>
		<li>Ŭ���̾�Ʈ�� ���ʷ� �� ������ �����ϸ� ������ �ش� Ŭ���̾�Ʈ���� 
			����ID�� �߱��Ѵ�</li>
		<li>����ID�� Ŭ���̾�Ʈ�� �����ϴµ� ����� �� �������� Ư�� �κ�(��Ű)��
			�����ȴ� (�ٸ� �� �������� ������ �����ϸ� ���ο� ����ID�� �߱޹޴´�)</li>
		<li>�� �������� ��Ű�� ����Ǿ��ִ� ����ID�� 
			���� Ŭ���̾�Ʈ�� ��û�� ���� �� ���� �׻� �Բ� ���۵Ǿ� ���ǰ�ä�� ���� ������ �Ѵ�</li>
		<li>����ID�� �⺻������ ������� �� �������� ����� �� ��������� �����Ǿ� �ִ�</li>
		<li>���� ��ü�� �����͸� �߰��ϴ� ���� ������ �ڿ��� �������� �� ��ŭ ����Ѵٴ� ���̱� ������
			�ʹ� ���� ���� �����͸� ���� ������ �����ϴ� ���� �����ϸ� �ȵȴ�.</li>
	</ol>
	
	<hr>
	
	<%
		// ������ ��Ȱ�� ���� �ð��� ����
		session.setMaxInactiveInterval(900);		
	%>
	
	<h3># ���� ���� ����</h3>
	
	<ul>
		<li>SESSION ID : <%=session.getId() %></li>
		<li>���� ���� �ð� : <%=new Date(session.getCreationTime()) %></li>
		<li>���������� Ȱ���� �ð� : <%=new Date(session.getLastAccessedTime()) %></li>
		<li>��Ȱ���� ���� ����Ǵ� �ð�:
			<%=session.getMaxInactiveInterval()%>��</li>
	</ul>
	
	<div>
		<a href="./invalidate">���� �����ϱ�</a>
	</div>
	
	<h3># ���� ���� ������ ������ ��� ����</h3>
	
	<div>
		<%
			// Enumeration : �ݺ����� ���� �� �ִ� �������̽�
			Enumeration<String> names = session.getAttributeNames();
			
			// session.Attribute�� ��� name�� value�� ���
			while (names.hasMoreElements()){
				String name = names.nextElement();
				
				out.print(String.format("%s=%s <br>", name, session.getAttribute(name)));
			};
		%>
	</div>
	
	<h3># ���� ������ ������ ���غ���</h3>
	
	<div>
		<form action="/chap04/session/add">
			key: 
			<select name="key" id="">
				<option value="appetite">����Ÿ����</option>
				<option value="main">����</option>
				<option value="furit">���ϼ���</option>
				<option value="dessert">����Ʈ ����</option>
			</select>
			
			value: <input type="text" name="value"/>
			<button type="submit">�߰�</button>
		</form>
	</div>
</body>
</html>