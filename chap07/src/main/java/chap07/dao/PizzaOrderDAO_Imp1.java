package chap07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap07.model.Pizza;
import chap07.model.PizzaOrder;

public class PizzaOrderDAO_Imp1 implements PizzaOrderDAO {
	
	
	@Override
	public List<PizzaOrder> getCustomerOrders(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public PizzaOrder getOrder(String order_id) {
		
		List<PizzaOrder> orders = new ArrayList<>();
		String sql = "SELECT order_id, address, pizza_name, pizza_option, pizza_price "
				+ " FROM pizza_order, pizza where pizza_order.pizza_id = pizza.pizza_id;";
		try(
		Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				PizzaOrder order = new PizzaOrder();
				Pizza pizza = new Pizza();
				order.setOrder_id(rs.getString("order_id"));
				order.setAddress(rs.getString("address"));
				pizza.setPizza_name(rs.getString("pizza_name"));
				pizza.setPizza_price(rs.getInt("pizza_price"));
				order.setPizza_option(rs.getInt("pizza_option"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (PizzaOrder) orders;
	}
	
	@Override
	public int deleteOrder(String order_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Pizza> getAllPizza() {
		List<Pizza> pizzas = new ArrayList<>();
		String sql = "SELECT * FROM pizza";
		try (
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setPizza_id(rs.getString("pizza_id"));
				pizza.setPizza_name(rs.getString("pizza_name"));
				pizza.setPizza_price(rs.getInt("pizza_price"));
				pizza.setAvail_option(rs.getInt("avail_option"));
				pizzas.add(pizza);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizzas;
	}
	
	@Override
	public int insertOrder(PizzaOrder pizza_order) {
		// 
		String sql = "SELECT pizza_order_seq.nextval AS order_id FROM dual";
		
		// INSERT 시 
		// 나중에 해당 테이블에 컬럼이 추가되는 상황에 대비해 모든 컬럼을 적어두는 것이 좋다
		String sql2 = "INSERT INTO"
				+ " pizza_order(order_id, customer_id, pizza_id, address, pizza_option)"
				+ " VALUES(?, ?, ?, ?, ?)";
		try (
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);	
			ResultSet rs = pstmt.executeQuery();
		){
			// 시퀀스로 꺼낸 다음 ID값을 Model 객체에 추가하여
			// 다음 리다이렉트의 파라미터로 사용할 수 있도록 한다
			rs.next();
			pizza_order.setOrder_id(rs.getString(1));
		
			pstmt2.setString(1, pizza_order.getOrder_id());
			pstmt2.setString(2, pizza_order.getCustomer_id());
			pstmt2.setString(3, pizza_order.getPizza_id());
			pstmt2.setString(4, pizza_order.getAddress());
			pstmt2.setInt(5, pizza_order.getPizza_option());
			
			return pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}	
}
