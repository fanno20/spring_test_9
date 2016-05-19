package com.hsh.p9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsh.member.MemberDTO;

@RestController
@RequestMapping("/iu/*")
public class TestRestController {
	
	/*@ResponseBody 가 생략*/
	@RequestMapping("/test")
	public String test(){
		return "hello choa";
	}
	
	/*@RequestMapping("/member/{number}")
	public MemberDTO test2(@PathVariable("number") int number){
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("choaID");
		memberDTO.setName("choaName");
		memberDTO.setPw(""+number);
		return memberDTO;
	}*/
	
	@RequestMapping(value="/member/{number}",method=RequestMethod.GET)
	public ResponseEntity<MemberDTO> test2(@PathVariable("number") int number){
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("choaID");
		memberDTO.setName("choaName");
		memberDTO.setPw(""+number);
		return new ResponseEntity<MemberDTO>(memberDTO,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/members")
	public List<MemberDTO> members(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("choaID");
		memberDTO.setName("choaName");
		memberDTO.setPw("choaPW");
		MemberDTO memberDTO2 = new MemberDTO();
		memberDTO2.setId("iuID");
		memberDTO2.setName("iuName");
		memberDTO2.setPw("iuPW");
		list.add(memberDTO);
		list.add(memberDTO2);
		return list;
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public ResponseEntity<String> write(@RequestBody MemberDTO memberDTO){
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
	
}







