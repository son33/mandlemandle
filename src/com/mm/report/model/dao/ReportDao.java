package com.mm.report.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mm.report.model.vo.Report;

public class ReportDao {

	public int insertReport(SqlSession session, Report r) {
		return session.insert("reportMapper.insertReport",r);
	}
}
