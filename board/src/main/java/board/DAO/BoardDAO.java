package board.DAO;

import java.util.List;

import board.common.Pagination;
import board.model.BoardDTO;

public interface BoardDAO {
	
	List<BoardDTO> getPage(Pagination page);
}
