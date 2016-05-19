package com.hsh.p9;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsh.note.NoteDTO;
import com.hsh.note.NoteService;

@RestController
@RequestMapping("/note/*")
public class NoteController {
	
	@Inject
	private NoteService noteService;
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ResponseEntity<String> write(@RequestBody NoteDTO noteDTO){
		String result = noteService.wirte(noteDTO);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<List<NoteDTO>> list(){
		List<NoteDTO> ar = noteService.list();
		return new ResponseEntity<List<NoteDTO>>(ar,HttpStatus.OK);
	}
	
	@RequestMapping(value="/view/{num}", method=RequestMethod.GET)
	public ResponseEntity<NoteDTO> view(@PathVariable int num){
		NoteDTO noteDTO = noteService.view(num);
		return new ResponseEntity<NoteDTO>(noteDTO, null);
	}
	
}





