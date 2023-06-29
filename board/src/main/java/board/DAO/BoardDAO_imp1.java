package board.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.common.Pagination;
import board.model.BoardDTO;

public class BoardDAO_imp1 implements BoardDAO{
	@Override
	public List<BoardDTO> getPage(Pagination page) {
		
		List<BoardDTO> boards = new ArrayList<>();
		
		String sql = "SELECT * FROM"
				+ " (SELECT rownum rn, A.* FROM (SELECT board.* FROM board ORDER BY board_id DESC) A)"
				+ " WHERE rn between ? AND ?";
		
		try(
			Connection conn = DBconnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
							
		){
			pstmt.setInt(1, page.getStart());
			pstmt.setInt(2, page.getEnd());
			
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				while(rs.next()) {
					BoardDTO board = new BoardDTO(rs);
					boards.add(board);					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
		
	}
}
