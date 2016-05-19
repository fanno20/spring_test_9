package com.hsh.note;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

	@Inject
	private NoteDAO noteDAO;

	@Override
	public String wirte(NoteDTO noteDTO) {
		String result;
		try {
			noteDAO.write(noteDTO);
			result = "Success";
		} catch (Exception e) {
			result = "Fail";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<NoteDTO> list() {
		try {
			return noteDAO.list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public NoteDTO view(int num) {
		try {
			return noteDAO.view(num);
		} catch (Exception e) {
			return null;
		}
	}

	
	
	
	
}
