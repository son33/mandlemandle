package com.mm.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.common.template.Template;
import com.mm.member.model.dao.MemberDao;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Portfolio;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = memberDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}
	
	@Override
	public int insertMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = memberDao.insertMember(sqlSession, m);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Portfolio> searchMentor1(String category) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Portfolio> list = memberDao.searchMentor1(sqlSession, category);
		sqlSession.close();
		return list;
	}
	@Override
	public ArrayList<Portfolio> searchMentor2(String category) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Portfolio> list = memberDao.searchMentor2(sqlSession, category);
		sqlSession.close();
		return list;
	}
	@Override
	public Member searchPwd(Member m) {
		SqlSession session = Template.getSqlSession();
		Member mem = memberDao.searchPwd(session, m);
		session.close();
		return mem;
	}

	@Override
	public int changePwd(Member changePwd) {
		SqlSession session = Template.getSqlSession();
		int result = memberDao.changePwd(session, changePwd);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public Member verifyEmail(String email) {
		SqlSession session = Template.getSqlSession();
		Member result = memberDao.verifyEmail(session, email);
		session.close();
		return result;
	}
}
