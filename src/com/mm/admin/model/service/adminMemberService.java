package com.mm.admin.model.service;

import java.util.ArrayList;

import com.mm.common.model.vo.PageInfo;
import com.mm.member.model.vo.Member;

public interface adminMemberService {

	int selectMentoCount();

	ArrayList<Member> selectMento(PageInfo pi);

	int deleteMento(int check);

	int selectMentiCount();

	ArrayList<Member> selectMenti(PageInfo pi);
}
