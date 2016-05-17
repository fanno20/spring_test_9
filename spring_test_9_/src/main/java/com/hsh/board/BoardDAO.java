package com.hsh.board;

import java.util.List;

public interface BoardDAO {
	
	public List<BoardDTO> list(MakePage mp) throws Exception;
	
	public int totlaList() throws Exception;
}
