package jspBoard.dao;

import jspBoard.model.BoardModel;

public interface BoardDAO {
	
	int newPost(BoardModel writer);
	
	int delete(int post_number);
}
