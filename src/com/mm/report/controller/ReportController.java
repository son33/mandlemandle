package com.mm.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.report.model.service.ReportService;
import com.mm.report.model.service.ReportServiceImpl;

/**
 * Servlet implementation class BoardReportController
 */
@WebServlet("/report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportService service = new ReportServiceImpl();
        
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String reportContent = request.getParameter("reportContent");
        int refUserNo = (request.getParameter("refUserNo") != null) ? Integer.parseInt(request.getParameter("refUserNo")) : 0;
        int refReplyNo = (request.getParameter("refReplyNo") != null) ? Integer.parseInt(request.getParameter("refReplyNo")) : 0;
        int refBno = (request.getParameter("refBno") != null) ? Integer.parseInt(request.getParameter("refBno")) : 0;

        int result = service.insertReport(userNo, reportContent, refUserNo, refReplyNo, refBno);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(result));
    }
}
