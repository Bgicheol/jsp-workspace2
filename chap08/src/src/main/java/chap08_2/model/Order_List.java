package chap08_2.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap08_2.dao.GetOrder;

public class Order_List {
	
	GetOrder dao = new GetOrder();
	
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		request.setAttribute("orders", dao.GetOrder());
		
		return "/pizza/order_list";
	}
}
