package com.mm.member.model.service;

import java.util.ArrayList;

import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Portfolio;

public interface MemberService {
	Member loginMember(Member m);
	int insertMember(Member m);
	ArrayList<Portfolio> searchMentor1(String category);
	ArrayList<Portfolio> searchMentor2(String category);
	Member searchPwd(Member m);
	int changePwd(Member changePwd);
	Member verifyEmail(String email);
}
