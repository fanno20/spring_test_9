package com.hsh.board;

import org.springframework.ui.Model;

public interface BoardService {
	
	public void list(int curPage,Model model,String type);
	
	public void boardWrite(BoardDTO boardDTO);
	
	public void boardView(int num, Model model);
	
	public void search(BoardSearchType boardSearchType,Model model);
	
}
