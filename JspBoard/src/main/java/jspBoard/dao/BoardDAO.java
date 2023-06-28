package jspBoard.dao;

import java.util.List;

import jspBoard.model.BoardModel;

public interface BoardDAO {
	
	int newPost(BoardModel writer);
	
	int delete(int post_number);
	
	List<BoardModel> getModel();
}
