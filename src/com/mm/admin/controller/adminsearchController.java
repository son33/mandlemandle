package com.mm.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Pagination;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class adminsearchController
 */
@WebServlet("/adminsearch")
public class adminsearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminsearchController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
		
		HashMap<String,String> map= new HashMap();
		map.put("condition",condition);
		map.put("keyword", keyword);
		
		adminBoardService service = new adminBoardServiceImpl();
		
		int searchCount = service.selectSearchCount(map);
		int currentPage =Integer.parseInt(request.getParameter("currentPage"));
		int pageLimit=10;
		int boardLimit=5;
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, pageLimit, boardLimit);
		
		ArrayList<Member> list = service.selectSearchList(map,pi);
		
		request.setAttribute("condition",condition );
		request.setAttribute("keyword",keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}