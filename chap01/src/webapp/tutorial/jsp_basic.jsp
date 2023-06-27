<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP �⺻</title>
</head>
<body>
	
	<h3># JSP</h3>
	
	<ul>
		<li>Java Server Pages (JSP)</li>
		<li>���� �� �������� �����ϱ� ���� Java API</li>
		<li>HTML �ȿ� Java �ڵ带 Ȱ���� �� �ִ�</li>
	</ul>
	
	<h3># Web Server</h3>
	
	<ul>
		<li>��û�� ���� �ش� URI�� �ڿ��� �����Ѵ�</li>
		<li>�׸� �ּ��� -> �׸��� ����</li>
		<li>html ������ �ּ��� -> ������ ����</li>
		<li>Apache-Tomcat���� Apache�� �� ������� �Ѵ�</li>
		<li>���� ������ ó��</li>
	</ul>
	
	<h3># Web Application Server</h3>
	
	<ul>
		<li>JSP ������ �ּ��� -> Java �ؼ� �� ���� -> .html ���� ���� -> ����</li>
		<li>�ܼ� ������ �ƴ�, ��Ȳ�� ���� ���ϴ� ���� ������ ó���� ����Ѵ�</li>
		<li>Apache-Tomcat���� Tomcat�� JSP�� �ؼ��� ����Ѵ�</li>
	</ul>
	
	<%--JSP �ּ� --%>
	
	<%--JSP Script --%>
	
	<%--
		<%  %> : �ش� ���� ���ο��� �ڹ� �ڵ带 ����� �� �ִ� (�޼��� ���� ���)
		<%= %> : �ڹٿ��� HTML�� ����Ѵ�
		<%! %> : �޼��带 ������ �� �ִ� (�ν��Ͻ� ���� ���)
		<%@ %> : JSP�� �ɼ� ����
	 --%>
	<% 
		String str = "Hello JSP";
		System.out.println("JSP ������ �������Դϴ�");
		
		out.print("<div style=\"color: skyblue;\">Hello!!!</div>");
	%>
	<%! 
		String rabbit() {
		return " /)/)\n"
			+  "(  ..)\n"
			+  "(  >$)";
	}
	%>
	<%="<div><b>�ȳ�</b>�ϼ���!</div>" %>
	<div style="color: coral;"><%=str %></div>
	<pre style="font-size: 25px"><%=rabbit() %></pre>
	
	<h3># JSP ������ ó�� ����</h3>
	
	<ol>
		<li>.jsp ������ �켱 .java ���Ϸ� ��ȯ�ȴ� (1�� ������)</li>
		<li>��ȯ�� .java ������ �������Ѵ� (2�� ������)</li>
		<li>�����ϵ� ������� �� �����̳�(Tomcat)�� ��ϵǾ� ������� ��û�� ��ٸ���</li>
		<li>Ŭ���̾�Ʈ�� �ش� �������� ��û�ϸ� �������̳� �� ��ϵǾ��ִ� 
			������ ������� �����Ͽ� ��û�� �����Ѵ�</li>
	</ol>
</body>
</html>