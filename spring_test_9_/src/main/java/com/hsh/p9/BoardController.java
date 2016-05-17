package com.hsh.p9;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsh.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public void boardList(@RequestParam int curPage, Model model){
		boardService.list(curPage, model);
	}
	/*board/boardList*/
}
