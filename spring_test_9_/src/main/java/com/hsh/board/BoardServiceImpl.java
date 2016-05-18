package com.hsh.board;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void list(int curPage, Model model,String type) {
		try {
			int totalList = boardDAO.totlaList();
			MakePage mp = new MakePage(curPage,totalList);
			mp.setType(type);
			model.addAttribute("page", mp);
			model.addAttribute("list", boardDAO.list(mp));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void boardWrite(BoardDTO boardDTO) {
		try {
			boardDAO.boardWrite(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void boardView(int num, Model model) {
		try {
			model.addAttribute(boardDAO.boardView(num));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void search(BoardSearchType boardSearchType,Model model) {
		try {
			model.addAttribute("list", boardDAO.search(boardSearchType));
			MakePage mp = new MakePage(1, boardDAO.totlaList());
			model.addAttribute("page", mp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
