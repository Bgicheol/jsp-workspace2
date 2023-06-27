<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%
	List<String> paths = (List)request.getAttribute("img_paths");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>갤러리</title>
	<link rel="stylesheet" href="<%=contextPath %>/resources/css/gallery.css" />
</head>
<body>
	
	<h5>/chap06/gallery/index로 이곳에 접속하게 만들어보기</h5>
	
	<h3># 갤러리입니다</h3>
	<div class="header" id="myHeader">
	  <h1>Image Grid</h1>
	  <p>Click on the buttons to change the grid view.</p>
	  <button class="btn" onclick="one()">1</button>
	  <button class="btn active" onclick="two()">2</button>
	  <button class="btn" onclick="four()">4</button>
	</div>
	<div  id='gallery' class='row'>
	<%for (int i = 0; i < 4; ++i) { %>
		<div class='column'>
	<% for (int j = 0; j <paths.size(); ++j) {%>
			<img src="<%=paths.get((int)(Math.random() * paths.size()))%>" alt="" style="width:100%"/>
	<% }%>
		</div>
	<%} %>
	</div>
	
	<script>
	var elements = document.getElementsByClassName('column');
	
	var i;
	
	function one() {
		for (i = 0; i < elements.length; ++i) {
			elements[i].style.flex="100%";
		}
	}
	function two() {
		for (i = 0; i < elements.length; ++i) {
			elements[i].style.flex="50%";
		}
	}
	function four() {
		for (i = 0; i < elements.length; ++i) {
			elements[i].style.flex="25%";
		}
	}
	
	var header = document.getElementById("myHeader");
	var btns = header.getElementsByClassName("btn");
	for (var i = 0; i < btns.length; i++) {
		btns[i].addEventListener("click", () => {
			var current = document.getElementsByClassName("active");
			current[0].className = current[0].className.replace("active", "");
			this.className += "active";
		});
	}
	</script>
</body>
</html>