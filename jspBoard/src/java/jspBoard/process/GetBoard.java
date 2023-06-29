package jspBoard.process;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.dao.BoardDAO;
import jspBoard.dao.BoardDAO_imp;

public class GetBoard implements BusinessLogic{
	BoardDAO dao = new BoardDAO_imp();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("list", dao.getModel());
		
		return "/board/main";
	}
}
