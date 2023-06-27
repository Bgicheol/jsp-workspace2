package chap07.process;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap07.dao.PizzaOrderDAO;
import chap07.dao.PizzaOrderDAO_Imp1;
import chap07.model.PizzaOrder;

public class PizzaOrderResultBusinessLogic implements BusinessLogic {
	PizzaOrderDAO dao = new PizzaOrderDAO_Imp1();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("EUC-KR");
	
		
		return "/pizza/result";
	}
}
