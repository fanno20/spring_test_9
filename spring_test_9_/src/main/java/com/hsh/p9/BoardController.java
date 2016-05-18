package com.hsh.p9;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsh.board.BoardDTO;
import com.hsh.board.BoardSearchType;
import com.hsh.board.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public void boardList(@RequestParam(defaultValue="1") int curPage, Model model,String type){
		boardService.list(curPage, model,type);
	}
	
	//write Form 연결
	@RequestMapping(value="/boarWrite",method=RequestMethod.GET)
	public void writeFrom(){}
	
	//write Form 연결
	@RequestMapping(value="/boarWrite",method=RequestMethod.POST)
	public String write(@ModelAttribute BoardDTO boardDTO){
		boardService.boardWrite(boardDTO);
		return "redirect:/board/boardList?curPage=1";
	}
	
	@RequestMapping(value="/boardView")
	public void boardView(@RequestParam int num, Model model){
		boardService.boardView(num, model);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(@ModelAttribute BoardSearchType boardSearchType, Model model){
		boardService.search(boardSearchType, model);
		return "board/boardList";
	}
	
}





