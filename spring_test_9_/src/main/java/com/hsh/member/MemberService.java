package com.hsh.member;

import javax.servlet.http.HttpSession;

public interface MemberService {
	
	public MemberDTO login(MemberDTO memberDTO);

	public void logout(HttpSession session);
	
}

