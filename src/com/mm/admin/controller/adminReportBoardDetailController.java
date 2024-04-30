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
import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;

/**
 * Servlet implementation class adminReportBoardDetailController
 */
@WebServlet("/adminReportBoardDetail")
public class adminReportBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminReportBoardDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int refBno = 0;
		
		if(request.getParameter("refBno") != null) {
			refBno = Integer.parseInt(request.getParameter("refBno"));
		}
		
		adminBoardService service = new adminBoardServiceImpl();
		
		Board b = service.selectReportBoardDetail(refBno);
		Attachment at = service.selectReportBoardFile(refBno);
		
		request.setAttribute("refBno", refBno);
		request.setAttribute("b", b);
		request.setAttribute("at",at);
		
		Gson gson = new Gson();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("board", b);
		dataMap.put("attachment", at);
		
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