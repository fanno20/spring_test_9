package com.hsh.p9;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsh.member.MemberDTO;
import com.hsh.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="loginForm", method=RequestMethod.GET)
	public void loginForm(){ }
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
		memberDTO = memberService.login(memberDTO);
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
			return "redirect:/";
		}else{
			return "redirect:/member/loginForm";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		memberService.logout(session);
		return "redirect:/";
	}
	
}
