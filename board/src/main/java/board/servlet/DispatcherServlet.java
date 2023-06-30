package board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardListService;
import board.service.BoardModifyService;
import board.service.*;

public class DispatcherServlet extends HttpServlet {
	private Map<String, Service> serviceMapping = new HashMap<>();
	 
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// config에서 application scope를 꺼내 contextPath를 꺼냄
		String contextPath = config.getServletContext().getContextPath();
		// 어떤 주소 + 요청 방식으로 접속했을 때 어떤 처리를 할 것인지 등록 ( 보여지는 곳)
		
		serviceMapping.put(contextPath + "/board/list::GET", new BoardListService());
		serviceMapping.put(contextPath + "/board/detail::GET", new BoardDetailService());
		serviceMapping.put(contextPath + "/board/modify::GET", new BoardModifyService());
		serviceMapping.put(contextPath + "/board/modify::POST", new BoardUpdateService());
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자의 요청을 받는다
		//request.setCharacterEncoding("EUC-KR");
		System.out.println("사용자가 요청한 URL : " + request.getRequestURL());
		System.out.println("사용자가 요청한 URI : " + request.getRequestURI());
		System.out.println("요청 방식 : " + request.getMethod());
		
		// 2. 요청 URI와 method에 맞는 처리를 진행한다
		//    -> uri와 method로 알맞은 RequestProcess를 골라 process()를 실행시킨다
		String nextPage = serviceMapping
				.get(request.getRequestURI() + "::" + request.getMethod())
				.service(request, response);
		
		// 3. 처리 후 알맞은 view 페이지로 포워드 하거나  redirect한다
		if (nextPage.startsWith("redirect:")) {
			response.sendRedirect(nextPage.substring("redirect:".length()));
		} else {
			// 포워드로는 WEB-INF 밑에 있는 페이지에 접근할 수 있다
			request.getRequestDispatcher("/WEB-INF/views" + nextPage + ".jsp").forward(request, response);
		}
			

	}
}
