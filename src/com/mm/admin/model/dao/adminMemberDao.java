package com.mm.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mm.common.model.vo.PageInfo;
import com.mm.member.model.vo.Member;

public class adminMemberDao {

	public int selectMentoCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectMentoCount");
	}

	public ArrayList<Member> selectMento(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Member> (sqlSession.selectList("adminMapper.selectMento",null,rowBounds));
	}

	public int deleteMento(SqlSession sqlSession, int check) {
		return sqlSession.update("adminMapper.deleteMento",check);
	}

	public int selectMentiCount(SqlSession sqlSession) {
		return sqlSession.selectOne("adminMapper.selectMentiCount");
	}

	public ArrayList<Member> selectMenti(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage()-1)*limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		return new ArrayList<Member> (sqlSession.selectList("adminMapper.selectMenti",null,rowBounds));
	}
}
