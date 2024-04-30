package com.mm.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;

/**
 * Servlet implementation class deleteReplyReportController
 */
@WebServlet("/deleteReplyReport")
public class deleteReplyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReplyReportController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminBoardService service = new adminBoardServiceImpl();

		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		int replyNo= Integer.parseInt(request.getParameter("replyNo"));
		
		int result1 = service.deleteReportList(reportNo);
		int result2 = service.deleteReplyReport(replyNo);
		
		JsonObject result = new JsonObject();
	    result.addProperty("result1", result1);
	    result.addProperty("result2", result2);
	    
	    Gson gson = new Gson();
	    String json = gson.toJson(result);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
