package com.mm.request.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.common.template.Template;
import com.mm.request.model.dao.RequestDao;
import com.mm.request.model.vo.Request;

public class RequestServiceImpl implements RequestService{

	private RequestDao requestDao = new RequestDao();

	@Override
	public int insertRequest(Request mtoRequest) {
		SqlSession session = Template.getSqlSession();
		int result = requestDao.insertRequest(session, mtoRequest);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public ArrayList<Request> getRequestList(Request rq) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Request> list = requestDao.getRequestList(session, rq);
		session.close();
		return list;
	}
	
	@Override
	public Request getMentorRequest(Request rq) {
		SqlSession session = Template.getSqlSession();
		Request rqe = requestDao.getMentorRequest(session, rq);
		session.close();
		return rqe;
	}
	
	@Override
	public Request selectRequest(Request mentorRequest) {
		SqlSession session = Template.getSqlSession();
		Request request = requestDao.selectRequest(session, mentorRequest);
		session.close();
		return request;
	}

	@Override
	public int refuseRequest(int requestNo) {
		SqlSession session = Template.getSqlSession();
		int result = requestDao.refuseRequest(session, requestNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int acceptRequest(int requestNo) {
		SqlSession session = Template.getSqlSession();
		int result = requestDao.acceptRequest(session, requestNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	@Override
	public int readRequest(int requestNo) {
		return 0;
	}
}
