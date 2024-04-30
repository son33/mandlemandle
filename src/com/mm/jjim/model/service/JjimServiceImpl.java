package com.mm.jjim.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.common.template.Template;
import com.mm.jjim.model.dao.JjimDao;
import com.mm.jjim.model.vo.Jjim;

public class JjimServiceImpl implements JjimService{

	private JjimDao jjimDao = new JjimDao();

	@Override
	public Jjim getJjim(Jjim jj) {
		SqlSession session = Template.getSqlSession();
		Jjim jjim = jjimDao.getJjim(session, jj);
		session.close();
		return jjim;
	}

	@Override
	public int insertJjim(Jjim jjim) {
		SqlSession session = Template.getSqlSession();
		int result = jjimDao.insertJjim(session, jjim);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int deleteJjim(Jjim jjim) {
		SqlSession session = Template.getSqlSession();
		int result = jjimDao.deleteJjim(session, jjim);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public ArrayList<Jjim> getJjimList(int mtiNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Jjim> jjimList = jjimDao.getJjimList(session, mtiNo);
		return jjimList;
	}
}
