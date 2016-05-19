package com.hsh.note;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDAOImpl implements NoteDAO{

	@Inject
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "NoteMapper.";
	
	@Override
	public void write(NoteDTO noteDTO) throws Exception {
		sqlSession.insert(NAMESPACE+"write", noteDTO);
	}

	@Override
	public List<NoteDTO> list() throws Exception {
		return sqlSession.selectList(NAMESPACE+"list");
	}

	@Override
	public NoteDTO view(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}

}
