package com.mm.report.model.service;

public interface ReportService {

	int insertReport(int userNo, String reportContent, int refUserNo, int refReplyNo, int refBno);
}
