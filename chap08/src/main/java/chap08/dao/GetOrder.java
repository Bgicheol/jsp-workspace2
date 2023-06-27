package chap08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap08.model.Order_info;

public class GetOrder {
	
	public List<Order_info> GetOrder() {
		List<Order_info> orders = new ArrayList<>();
		
		String sql = "SELECT order_id, address, pizza_name, pizza_price FROM "
				+ "pizza_order, pizza where pizza_order.pizza_id = pizza.pizza_id";
		
		try (
				Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				Order_info order = new Order_info();
				order.setOrder_id(rs.getString("order_id"));
				order.setAddess(rs.getString("address"));
				order.setPizza_name(rs.getString("pizza_name"));
				order.setPizza_price(rs.getInt("pizza_price"));
				orders.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
