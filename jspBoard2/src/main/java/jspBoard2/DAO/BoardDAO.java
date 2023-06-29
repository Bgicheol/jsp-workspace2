package jspBoard2.DAO;

import java.util.List;

import jspBoard2.common.Pagination;
import jspBoard2.model.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> getPage(Pagination page);	
	
}
