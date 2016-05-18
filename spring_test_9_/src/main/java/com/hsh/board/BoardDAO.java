package com.hsh.board;

import java.util.List;

public interface BoardDAO {
	
	public List<BoardDTO> list(MakePage mp) throws Exception;
	
	public int totlaList() throws Exception;
	
	public void boardWrite(BoardDTO boardDTO) throws Exception;
	
	public BoardDTO boardView(int num) throws Exception;
	
	public List<BoardDTO> search(BoardSearchType boardSearchType) throws Exception;
}
