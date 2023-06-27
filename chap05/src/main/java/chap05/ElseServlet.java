package chap05;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ElseServlet extends HttpServlet {
	
	
	// init() : 서블잇이 처음 실행되는 시점에 호출되는 메서드
	//			init()는 해당 서블릿으로 첫 요청이 발생했을 때 실행된다
	@Override
	public void init(ServletConfig config) throws ServletException {
	  System.out.println(config.getInitParameter("main_color"));
	  System.out.println(config.getInitParameter("logo_path"));
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP application scope
		ServletContext application = request.getServletContext();
		
		// web.xml에서 등록한 context-param은 application scope에 들어있다
		System.out.println(application.getInitParameter("account_id"));
		System.out.println(application.getInitParameter("account_pw"));
		
		// JSP session scope의 서블릿 버전
		HttpSession session = request.getSession();
		
		// .jsp의 맨 위에 자동으로 설정되던 것을 수동으로 설정해야 한다.
		response.setCharacterEncoding("EUC-KR");
		response.getWriter()
			.append("<html><head><title>ElseServlet</title></head>")
			.append("<body>한글?</body>");
	}
}
