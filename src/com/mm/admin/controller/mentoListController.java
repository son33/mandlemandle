package com.mm.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;
import com.mm.admin.model.service.adminMemberService;
import com.mm.admin.model.service.adminMemberServiceImpl;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Pagination;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class mentoListController
 */
@WebServlet("/mentoList")
public class mentoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mentoListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminMemberService service = new adminMemberServiceImpl();
		adminBoardService bService = new adminBoardServiceImpl();
		
		String condition = request.getParameter("condition");
		String keyword = request.getParameter("keyword");
	
		HashMap<String,String> map= new HashMap<String, String>();
		map.put("condition",condition);
		map.put("keyword", keyword);
		
		int count = 0;
		int pageLimit=10;
		int boardLimit=10;
		int currentPage = 1;
		ArrayList<Member> list = null;
		
		if(condition != null) {
			count = bService.selectSearchCount(map);
		}else {
			count = service.selectMentoCount();
		}
		if(request.getParameter("currentPage") != null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageInfo pi = Pagination.getPageInfo(count, currentPage, pageLimit, boardLimit);
		
		if(condition != null) {
			list =bService.selectSearchList(map,pi);
		}else {
			list =service.selectMento(pi);
		}
		
		request.setAttribute("condition",condition );
		request.setAttribute("keyword",keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
						
		request.getRequestDispatcher("WEB-INF/views/admin/adminmentoList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}