package com.mm.request.model.service;

import java.util.ArrayList;

import com.mm.jjim.model.vo.Jjim;
import com.mm.request.model.vo.Request;

public interface RequestService {

	int insertRequest(Request mtoRequest);

	Request selectRequest(Request mentorRequest);
	
	Request getMentorRequest(Request rq);
	
	ArrayList<Request> getRequestList(Request rq);

	int refuseRequest(int requestNo);

	int acceptRequest(int requestNo);

	int readRequest(int requestNo);
}
