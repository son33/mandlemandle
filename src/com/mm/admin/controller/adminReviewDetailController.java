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
import com.mm.portfolio.model.vo.Review;

/**
 * Servlet implementation class adminReviewDetailController
 */
@WebServlet("/adminReviewDetail")
public class adminReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminReviewDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = 0;
		
		if(request.getParameter("reviewNo") != null) {
			reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		}
		
		adminBoardService service = new adminBoardServiceImpl();
		
		Review r = service.selectReviewDetail(reviewNo);
		Attachment at = service.selectReviewFile(reviewNo);
		
		request.setAttribute("reviewNo", reviewNo);
		request.setAttribute("r", r);
		request.setAttribute("at",at);
		
		Gson gson = new Gson();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("review",r);
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
