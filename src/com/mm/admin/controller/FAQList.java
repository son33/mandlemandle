package com.mm.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;
import com.mm.board.model.vo.Board;

/**
 * Servlet implementation class FAQList
 */
@WebServlet("/FAQList")
public class FAQList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQList() {
        super();
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminBoardService service = new adminBoardServiceImpl();
		
		ArrayList<Board> list = service.selectFAQList();		
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/admin/FAQList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
