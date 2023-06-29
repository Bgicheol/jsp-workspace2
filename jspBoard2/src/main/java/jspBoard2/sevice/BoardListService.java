package jspBoard2.sevice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard2.DAO.BoardDAO;
import jspBoard2.DAO.BoardDAO_imp1;
import jspBoard2.common.Pagination;

public class BoardListService implements Service {
	
	BoardDAO boardDAO = new BoardDAO_imp1();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// DB에서 글 목록을 조회해야한다 (현재 페이지의 10개)
		int page;
		
		try {				
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		Pagination pagination = new Pagination(page, 10);
		// page -> SELECT * FROM board WHERE board_id BETWEEN A AND B
		request.setAttribute("boards", 
				boardDAO.getPage(pagination));		
		request.setAttribute("page", pagination);
		// /WEB-INF/views/board/list.jsp로 포워드
		return "/board/list";
	}
}
