package com.mm.area.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.area.model.dao.AreaDao;
import com.mm.area.model.vo.Sido;
import com.mm.area.model.vo.Sigungu;
import com.mm.common.template.Template;

public class AreaServiceImpl implements AreaService{
	
	private AreaDao areaDao = new AreaDao();

	@Override
	public ArrayList<Sido> getSido() {
		SqlSession session = Template.getSqlSession();
		ArrayList<Sido> list = areaDao.getSido(session);
		session.close();
		return list;
	}

	@Override
	public ArrayList<Sigungu> getSigungu(int sidoNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Sigungu> list = areaDao.getSigungu(session, sidoNo);
		session.close();
		return list;
	}
}
