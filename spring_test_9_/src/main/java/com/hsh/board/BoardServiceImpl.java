package com.hsh.board;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void list(int curPage, Model model) {
		try {
			int totalList = boardDAO.totlaList();
			MakePage mp = new MakePage(curPage,totalList);
			model.addAttribute("page", mp);
			model.addAttribute("list", boardDAO.list(mp));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
