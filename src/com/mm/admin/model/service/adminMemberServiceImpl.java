package com.mm.admin.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.admin.model.dao.adminMemberDao;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Template;
import com.mm.member.model.vo.Member;

public class adminMemberServiceImpl implements adminMemberService{
	
	private adminMemberDao memberDao = new adminMemberDao();

	@Override
	public int selectMentoCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = memberDao.selectMentoCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Member> selectMento(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Member> list = memberDao.selectMento(sqlSession,pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int deleteMento(int check) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = memberDao.deleteMento(sqlSession,check);
		if(result > 0) sqlSession.commit();
		else sqlSession.rollback();
		sqlSession.close();
		return result;
	}

	@Override
	public int selectMentiCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = memberDao.selectMentiCount(sqlSession);
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Member> selectMenti(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Member> list = memberDao.selectMenti(sqlSession,pi);
		sqlSession.close();
		return list;
	}
}
