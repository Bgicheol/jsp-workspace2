package chap09.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/add")
public class AddCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// response.addCookie()로 사용자의 웹 브라우저에 쿠키를 추가할 수 있다
		// 같은 name 이더라도 path가 다르면 다른 쿠키로 인식된다
		// path와 maxAge를 설정하였음
		Cookie cookie1 = new Cookie("myname", "김철수");		
		cookie1.setPath("/"); 
		cookie1.setMaxAge(30); // 30초 뒤로 사라지는 쿠키 브라우저를 꺼도 시간만큼 유지됨
		response.addCookie(cookie1);
		
		// path도 설정하지 않고 maxAge도 설정하지 않음
		// paht의 기본 값은 현재경로가 된다 (여기서는 /chap09/cookie)
		// maxAge의 기본 값은 -1이 된다. -1은 수명이 세션과 같아진다
		response.addCookie(new Cookie("age", "30"));
		response.addCookie(new Cookie("mainfood", "rice"));
		
		response.sendRedirect("./index.jsp");
	}

}
