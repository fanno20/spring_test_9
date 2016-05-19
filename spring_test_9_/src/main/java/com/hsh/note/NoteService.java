package com.hsh.note;

import java.util.List;

public interface NoteService {

	public String wirte(NoteDTO noteDTO);
	
	public List<NoteDTO> list();

	public NoteDTO view(int num); 
}
