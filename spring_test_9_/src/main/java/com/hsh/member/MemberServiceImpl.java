package com.hsh.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO memberDAO;
	
	@Override
	public MemberDTO login(MemberDTO memberDTO) {
		try {
			memberDTO = memberDAO.login(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberDTO;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}





