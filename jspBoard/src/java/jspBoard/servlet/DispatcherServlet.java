package jspBoard.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.process.BusinessLogic;
import jspBoard.process.GetBoard;
import jspBoard.process.InsertBoard;

public class DispatcherServlet extends HttpServlet {
	
	/*
	  # 게시판을 만들어 보세요
	  
	  - 별도의 인증과정 없이도 글쓴이와 비밀번호를 설정하고 글을 쓸 수 있다
	  - 해당 글을 수정하거나 삭제하려면 비밀번호를 거쳐야 한다
	  - 글 목록을 볼 떄 글 제목이 한 페이지에 10개씩 나와야 한다 
	  - 최근에 적은 글이 가장 위에 보여야 한다
	  - 글 번호는 반드시 시퀀스를 통해 부여할 것
	  
	  
	  - 글 목록에서 제목을 클릭하면 해당 글의 상세 내용을 보는 페이지로 넘어가고
	  - 글의 내용을 볼 때 마다 조회수가 올라가야 한다
	  	(단, 조회수는 한 브라우저당 10분에 1회씩만 올릴 수 있다
	  - 글 쓰기 기능이 있다. 
	  - 글 수정 및 삭제 기능이 있다.	
	  - 존재하는 글에 댓글을 달 수 있으며 댓글을 달 때도 글쓴이와 비밀번호를 설정할 수 있다
	  - 댓글도 비밀번호를 맞추면 수정 및 삭제가 가능하다
	  - 추천과 비추천이 존재한다
	  	(이미 추천 또는 비추천을 했던 사람이 다시 클릭하면 추천 또는 비추천이 취소될 수 있다
	*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1066319703918937241L;
	private Map<String, BusinessLogic > processMapping = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String contextPath = config.getServletContext().getContextPath();
		processMapping.put(contextPath + "/board/main::GET", new GetBoard());
		processMapping.put(contextPath + "/board/post::POST", new InsertBoard());	
	//processMapping.put(contextPath + "/board/main::POST", new InsertBoard());
		System.out.println(contextPath);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nextPage = processMapping
					.get(request.getRequestURI() + "::" + request.getMethod())
					.process(request, response);
			System.out.println("사용자가 요청한 URL : " + request.getRequestURL());
			System.out.println("사용자가 요청한 URI : " + request.getRequestURI());
			System.out.println("요청 방식 : " + request.getMethod());
			if (nextPage.startsWith("redirect:")) {
				response.sendRedirect(nextPage.substring("redirect:".length()));
			} else {
				request.getRequestDispatcher("/board/" + nextPage + ".jsp").forward(request, response);
			}
		} catch (NullPointerException e) {
			request.getRequestDispatcher("/WEB-INF/error/unknown_uri.jsp").forward(request, response);
		}
	}
}
