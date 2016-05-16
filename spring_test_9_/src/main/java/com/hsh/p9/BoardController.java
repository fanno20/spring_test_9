package com.hsh.p9;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@RequestMapping("/boardList")
	public void boardList(){	}
	/*board/boardList*/
}
