package jspBoard2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "hr", "1234");
	}
	
	public static Connection getConnection(String url, String id, String pw ) 
			throws SQLException{
		return DriverManager.getConnection(url, id, pw);
	}
}
