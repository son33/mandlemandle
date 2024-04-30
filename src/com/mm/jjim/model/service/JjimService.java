package com.mm.jjim.model.service;

import java.util.ArrayList;

import com.mm.jjim.model.vo.Jjim;

public interface JjimService {
	Jjim getJjim(Jjim jjim);

	int insertJjim(Jjim jjim);

	int deleteJjim(Jjim jjim);
	
	ArrayList<Jjim> getJjimList(int mtiNo);
}
