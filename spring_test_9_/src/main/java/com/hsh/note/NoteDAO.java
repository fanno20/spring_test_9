package com.hsh.note;

import java.util.List;

public interface NoteDAO {

	//note write
	public void write(NoteDTO noteDTO) throws Exception;
	
	//note list
	public List<NoteDTO> list() throws Exception;
	
	public NoteDTO view(int num) throws Exception;
}
