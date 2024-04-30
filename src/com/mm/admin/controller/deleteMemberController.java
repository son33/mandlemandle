package com.mm.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.admin.model.service.adminMemberService;
import com.mm.admin.model.service.adminMemberServiceImpl;

/**
 * Servlet implementation class DeleteMemberController
 */
@WebServlet("/admindelete.me")
public class deleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteMemberController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminMemberService service = new adminMemberServiceImpl();
		
		int check= Integer.parseInt(request.getParameter("check"));
		int currentPage = 1;
		if(request.getParameter("currentPage") != null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int result = service.deleteMento(check);
				
		request.getRequestDispatcher("WEB-INF/views/admin/adminmentoList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
