package jspBoard.process;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspBoard.dao.BoardDAO;
import jspBoard.dao.BoardDAO_imp;
import jspBoard.model.BoardModel;

public class Board implements BusinessLogic {
	BoardDAO dao = new BoardDAO_imp();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("EUC-KR");
		
		
		String title = request.getParameter("title");
		String writer =request.getParameter("writer");
		String writer_pw = request.getParameter("writer_pw");
		String post = request.getParameter("post");
		
		// 전달받은 파라미터에 잘못된 값이 있으면 다시 입력하도록 만들기
		if (
			title == null || title.trim().equals("") ||
			writer == null || writer.trim().equals("") ||
			writer_pw == null || writer_pw.trim().equals("") ||
			post== null || post.trim().equals("") 			
		) {
			return "redirect:" + request.getContextPath() + "./post.jsp";
		}
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(writer_pw);
		System.out.println(post);
		
		// DB에 inser 진행
		BoardModel write = new BoardModel();
		write.setTitle("title");
		write.setWriter("writer");
		write.setWriter_qw("writer_pw");
		write.setPost("post");

		dao.newPost(write);
		return "redirect:" + request.getContextPath() + "./main.jsp";
	}
	
}
	
