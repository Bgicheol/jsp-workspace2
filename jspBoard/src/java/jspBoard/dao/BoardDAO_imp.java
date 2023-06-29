package jspBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspBoard.model.BoardModel;

public class BoardDAO_imp implements BoardDAO{
	@Override
	public int newPost(BoardModel writer) {
		
		String sql = "INSERT INTO"
				+ " board(post_number, title, writer, writer_pw, post)"
				+ " VALUES(post_number_seq.nextval, ?, ?, ?, ?)";
		try (
			Connection conn = DBconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
		){
			
			pstmt.setString(1, writer.getTitle());
			pstmt.setString(2, writer.getWriter());
			pstmt.setString(3, writer.getWriter_qw());
			pstmt.setString(4, writer.getPost());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
		
	}
	
	@Override
	public List<BoardModel> getModel() {
		List<BoardModel> list =new ArrayList<>();
		String sql = "SELECT * FROM board";
		try (
			Connection conn = DBconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				BoardModel dao = new BoardModel();
				dao.setPost_number(rs.getInt("post_number"));
				dao.setTitle(rs.getString("title"));
				dao.setWriter(rs.getString("writer"));
				dao.setWriter_qw(rs.getString("writer_pw"));
				dao.setPost(rs.getString("post"));
				list.add(dao);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}			
		return list;
	}
	
	
	@Override
	public int delete(int post_number) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
	
	
