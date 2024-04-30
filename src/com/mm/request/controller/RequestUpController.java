package com.mm.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.request.model.service.RequestService;
import com.mm.request.model.service.RequestServiceImpl;

/**
 * Servlet implementation class RequestUpController
 */
@WebServlet("/request.up")
public class RequestUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestUpController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl();
		
		int requestNo = Integer.parseInt(request.getParameter("requestNo"));
		String requestStatus = request.getParameter("requestStatus");
		if(requestStatus.equals("N") || requestStatus.equals("W")) {
			
		}
		int result = service.readRequest(requestNo);
		response.sendRedirect("/request?requestNo="+requestNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
