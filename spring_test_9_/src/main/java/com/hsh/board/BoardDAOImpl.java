package com.hsh.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String SPACENAME="BoardMapper.";
	
	@Override
	public List<BoardDTO> list(MakePage mp) throws Exception {
		List<BoardDTO> ar = sqlSession.selectList(SPACENAME+"list", mp);
		return ar;
	}

	@Override
	public int totlaList() throws Exception {
		return sqlSession.selectOne(SPACENAME+"totalList");
	}

	@Override
	public void boardWrite(BoardDTO boardDTO) throws Exception {
		int num = sqlSession.insert(SPACENAME+"boardWrite", boardDTO);
		System.out.println("num: "+num);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return sqlSession.selectOne(SPACENAME+"boardView", num);
	}

	@Override
	public List<BoardDTO> search(BoardSearchType boardSearchType) throws Exception {
		List<BoardDTO> ar = sqlSession.selectList(SPACENAME+"search", boardSearchType);
		return ar;
	}

}
