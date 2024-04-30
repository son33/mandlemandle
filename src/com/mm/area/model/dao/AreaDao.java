package com.mm.area.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.area.model.vo.Sido;
import com.mm.area.model.vo.Sigungu;

public class AreaDao {

	public ArrayList<Sido> getSido(SqlSession session) {
        return new ArrayList<>(session.selectList("areaMapper.selectSido"));
	}

	public ArrayList<Sigungu> getSigungu(SqlSession session, int sidoNo) {
		return new ArrayList<>(session.selectList("areaMapper.selectSigungu",sidoNo));
	}

}
