package chap04.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quizA/register")
public class RegisterServlet extends HttpServlet{
	
	public static List<MemoUser> memo_users = new ArrayList<>();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		MemoUser n_user = new MemoUser(user_id, user_pwd);
		
		if (memo_users.contains(n_user)) {
			// 중복된 아이디를 페이지로 포워딩
			request.getRequestDispatcher("./exist_id.jsp").forward(request, response);
		} else {
			//회원가입 성공
			memo_users.add(n_user);
			response.sendRedirect("./quizA.jsp");
		}
		
	};
	
	
}
