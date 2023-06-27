package chap03.newservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forwardtest")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 자바로 처리하고 싶은 내용들을 처리한다...
		String type = req.getParameter("type");
		String price = req.getParameter("price");
		String name = req.getParameter("name");
		String qty = req.getParameter("qty");
		
		int total_price = 0;
		
		if (price != null && qty != null) {
			System.out.printf("%s(%s) / %d\n", 
						name, type, 
						total_price = (Integer.parseInt(price) * Integer.parseInt(qty)));
			
		} else {
			// 하나라도 null값이 존재하면 정상적인 접근이 아니므로
			// 다시 index.jps로 요청하라고 응답을 보낼 수 있다.
			resp.sendRedirect("/chap03/forward/index.jsp");
			return;
		}
		
		// 처리 후 얻어낸 결과를 다음 서블릿까지 전달하고 싶을 떄는 
		// request 객체에 데이터를 실어 보낼 수 있다 (attribute)
		req.setAttribute("full_name", String.format("%s(%s)", name, qty));
		req.setAttribute("total_price",total_price);
		
		// 요청을 다른 곳으로 넘기기 위한 기능들이 들어있는 객체
		// forward : 요청 객체를 다른 곳으로 넘겨 처리한 후 그곳에서 응답한다
		// include : 요청 객체를 다른 곳으로 넘겨 처리한 후 다시 돌아온다
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/forward/view.jsp");
		dispatcher.forward(req, resp);
	}
}
