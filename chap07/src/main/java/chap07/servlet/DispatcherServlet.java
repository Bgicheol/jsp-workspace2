package chap07.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.process.BusinessLogic;
import chap07.process.PizzaOrderFormBusinessLogic;
import chap07.process.PizzaOrderInsertBussinessLogic;
import chap07.process.PizzaOrderResultBusinessLogic;

// 모든 요청을 맡아서 처리하는 포워드 전문 서블릿 (프론트 컨트롤러 디자인 패턴)
public class DispatcherServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936672165589953706L;
	private Map<String, BusinessLogic> processMapping = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// config에서 application scope를 꺼내 contextPath를 꺼냄
		String contextPath = config.getServletContext().getContextPath();
		// 어떤 주소 + 요청 방식으로 접속했을 때 어떤 처리를 할 것인지 등록 ( 보여지는 곳)
		processMapping.put(contextPath + "/pizza/order::GET", new PizzaOrderFormBusinessLogic());
		// 폼에서 보내줄 방법 골라내고 여기서 보내는 위치를 선정
		processMapping.put(contextPath + "/pizza/order::POST", new PizzaOrderInsertBussinessLogic());
		processMapping.put(contextPath + "/pizza/order/result::GET", new PizzaOrderResultBusinessLogic());
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자의 요청을 받는다
		System.out.println("사용자가 요청한 URL : " + request.getRequestURL());
		System.out.println("사용자가 요청한 URI : " + request.getRequestURI());
		System.out.println("요청 방식 : " + request.getMethod());
		
		// 2. 요청 URI와 method에 맞는 처리를 진행한다
		//    -> uri와 method로 알맞은 RequestProcess를 골라 process()를 실행시킨다
		try {
			String nextPage = processMapping
					.get(request.getRequestURI() + "::" + request.getMethod())
					.process(request, response);
			
			// 3. 처리 후 알맞은 view 페이지로 포워드 하거나  redirect한다
			if (nextPage.startsWith("redirect:")) {
				response.sendRedirect(nextPage.substring("redirect:".length()));
			} else {
				// 포워드로는 WEB-INF 밑에 있는 페이지에 접근할 수 있다
				request.getRequestDispatcher("/WEB-INF/views" + nextPage + ".jsp").forward(request, response);
			}
		} catch (NullPointerException e) {
			request.getRequestDispatcher("/WEB-INF/views/error/unknown_uri.jsp").forward(request, response);
		}
			
	}
}
