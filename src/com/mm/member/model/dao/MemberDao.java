package com.mm.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.vo.Portfolio;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember",m);
	}

	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember",m);
	}
	
	public ArrayList<Portfolio> searchMentor1(SqlSession sqlSession, String category) {
		return new ArrayList<Portfolio> (sqlSession.selectList("searchMapper.searchMentor1",category));
	}
	
	public ArrayList<Portfolio> searchMentor2(SqlSession sqlSession, String category) {
		return new ArrayList<Portfolio> (sqlSession.selectList("searchMapper.searchMentor2",category));
	}

	public Member searchPwd(SqlSession session, Member m) {
		return session.selectOne("memberMapper.searchPwd",m);
	}

	public int changePwd(SqlSession session, Member changePwd) {
		return session.update("memberMapper.changePwd", changePwd);
	}

	public Member verifyEmail(SqlSession session, String email) {
		return session.selectOne("memberMapper.verifyEmail",email);
	}
}
