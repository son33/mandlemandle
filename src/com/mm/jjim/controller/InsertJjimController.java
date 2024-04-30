package com.mm.jjim.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.jjim.model.service.JjimService;
import com.mm.jjim.model.service.JjimServiceImpl;
import com.mm.jjim.model.vo.Jjim;

/**
 * Servlet implementation class InsertJjimController
 */
@WebServlet("/jjim.in")
public class InsertJjimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertJjimController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JjimService service = new JjimServiceImpl();
		
		int mtiNo = Integer.parseInt(request.getParameter("mtiNo"));
		int mtoNo = Integer.parseInt(request.getParameter("mtoNo"));
		
		new Jjim();
		Jjim jjim = Jjim.builder().mtiNo(mtiNo).mtoNo(mtoNo).build();
		int result = service.insertJjim(jjim);
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(result));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
