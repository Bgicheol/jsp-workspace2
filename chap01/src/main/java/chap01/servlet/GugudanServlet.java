package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	/chap01/gugudan 으로 접속하는 사용자들에게 
 	 멋있는 구구단 페이지를 응답하는 서블릿을 만들어보세요
 */

//@WebServlet("/chap01/gugudan")
@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답 객체에서 사용할 charset을 설정한다
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
//		out.print("<html><head>"
//				+ "<title>Gugudan</title>"
//				+ "</head><body");
//		out.print("<div style='display: grid; grid-template-columns:repeat(10,1fr);"
//				+ "text-align:center; font-size: 20px;column-gap: 3px;row-gap: 3px;"
//				+ "'>");
//			for (int i = 2; i <= 9; ++i) {
//					out.print("<div style='border: solid 1px black; font-size: 25px; background-color:red; color:blue;'>" + i + "dan" + "</div>");
//				for (int j = 1; j <= 9; ++j) {
//					out.print("<div style='border: solid 1px black; font-size:20px;background-color: blue; color:red;'>"
//							+i+"x"+j+"="+i*j+
//							"</div>");
//					
//				}
//			}
//			
//		out.print("</div>");
//		out.print("</body></html>");
		
		out.print("<html lang=\"ko\"><head><title>구구단</title>"
				+ "<meta charset=\"UTF-8\">"
				+ "<link rel=\"stylesheet\" href=\"./assets/gugudan.css\">"
				+ "</head><body>"
				+ "<div id=\"gugudan\"></div>"
				+ "<script src=\"./assets/gugudan.js\"></script>"
				+ "</body></html>");
	}
}
