package com.mm.report.model.service;

import org.apache.ibatis.session.SqlSession;

import com.mm.common.template.Template;
import com.mm.report.model.dao.ReportDao;
import com.mm.report.model.vo.Report;

public class ReportServiceImpl implements ReportService {
	ReportDao reportDao = new ReportDao();
	
	@Override
	public int insertReport(int userNo, String reportContent, int refUserNo, int refReplyNo, int refBno) {
		SqlSession session = Template.getSqlSession();
		Report r = new Report();
		r.setUserNo(userNo);
		r.setReportContent(reportContent);
		if(refUserNo != 0) {
			r.setRefUserNo(refUserNo);
		}
		if(refReplyNo != 0) {
			r.setRefReplyNo(refReplyNo);
		}
		if(refBno != 0) {
			r.setRefBno(refBno);
		}
		int result = reportDao.insertReport(session, r);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
