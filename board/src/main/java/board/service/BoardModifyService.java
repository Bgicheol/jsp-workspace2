package board.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.DAO.BoardDAO;
import board.DAO.BoardDAO_imp1;

public class BoardModifyService implements Service{
	
	BoardDAO boardDAO = new BoardDAO_imp1();
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String id = request.getParameter("id");
		
		int iid = Integer.parseInt(id);
		
		request.setAttribute("board", boardDAO.get(iid));
		
		return "/board/modify";
	}
	
}
