package com.mm.request.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.request.model.vo.Request;

public class RequestDao {

	public int insertRequest(SqlSession session, Request mtoRequest) {
		return session.insert("requestMapper.insertRequest",mtoRequest);
	}

	public Request getMentorRequest(SqlSession session, Request rq) {
		return session.selectOne("requestMapper.getMentorRequest",rq);
	}
	
	public Request selectRequest(SqlSession session, Request mentorRequest) {
		return session.selectOne("requestMapper.selectRequest",mentorRequest);
	}

	public ArrayList<Request> getRequestList(SqlSession session, Request rq) {
		return new ArrayList<Request> (session.selectList("requestMapper.getRequestList",rq));
	}

	public int refuseRequest(SqlSession session, int requestNo) {
		return session.update("requestMapper.refuseRequest",requestNo);
	}

	public int acceptRequest(SqlSession session, int requestNo) {
		return session.update("requestMapper.acceptRequest",requestNo);
	}
}
