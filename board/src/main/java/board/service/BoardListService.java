package board.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.DAO.BoardDAO;
import board.DAO.BoardDAO_imp1;
import board.common.Pagination;

public class BoardListService implements Service {
	
	BoardDAO boardDAO = new BoardDAO_imp1();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int boardCount = boardDAO.getBoardCount();
		int page;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			
			page = 1;
		}
		Pagination pagination = new Pagination(page, 10, boardDAO.getBoardCount());
		
		request.setAttribute("boards", boardDAO.getPage(pagination));
		request.setAttribute("page", pagination);
		return "/board/list";
	}

}
