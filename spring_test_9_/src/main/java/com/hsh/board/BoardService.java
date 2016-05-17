package com.hsh.board;

import org.springframework.ui.Model;

public interface BoardService {
	
	public void list(int curPage,Model model);

}
