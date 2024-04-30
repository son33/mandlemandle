package com.mm.jjim.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.jjim.model.vo.Jjim;

public class JjimDao {

	public Jjim getJjim(SqlSession session, Jjim jj) {
		return session.selectOne("jjimMapper.getJjim",jj);
	}

	public int insertJjim(SqlSession session, Jjim jjim) {
		return session.insert("jjimMapper.insertJjim",jjim);
	}

	public int deleteJjim(SqlSession session, Jjim jjim) {
		return session.delete("jjimMapper.deleteJjim",jjim);
	}

	public ArrayList<Jjim> getJjimList(SqlSession session, int mtiNo) {
		return new ArrayList<Jjim>(session.selectList("jjimMapper.getJjimList",mtiNo));
	}

}
