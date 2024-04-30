package com.mm.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;
import com.mm.board.model.vo.Reply;

/**
 * Servlet implementation class adminReportReplyDetailController
 */
@WebServlet("/adminReportReplyDetail")
public class adminReportReplyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminReportReplyDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = 0;
		
		if(request.getParameter("replyNo") != null) {
			replyNo = Integer.parseInt(request.getParameter("replyNo"));
		}
		
		adminBoardService service = new adminBoardServiceImpl();
		Reply b = service.selectReportReplyDetail(replyNo);
		
		request.setAttribute("replyNo", replyNo);
		request.setAttribute("b", b);
		
		Gson gson = new Gson();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("board", b);
		
		String json = gson.toJson(dataMap);
		
	   response.setContentType("application/json; charset=UTF-8");
	   response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}