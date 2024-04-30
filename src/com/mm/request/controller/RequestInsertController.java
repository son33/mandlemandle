package com.mm.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.request.model.service.RequestService;
import com.mm.request.model.service.RequestServiceImpl;
import com.mm.request.model.vo.Request;

/**
 * Servlet implementation class RequestInsertController
 */
@WebServlet("/request.in")
public class RequestInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl();
		
		int mtiNo = Integer.parseInt(request.getParameter("mtiNo"));
		int mtoNo = Integer.parseInt(request.getParameter("mtoNo"));
		int refPno = Integer.parseInt(request.getParameter("refPno"));
		String requestContent = request.getParameter("requestContent");
		
		new Request();
		Request mtoRequest = Request.builder().requestContent(requestContent).mtiNo(mtiNo).mtoNo(mtoNo).build();
		int result = service.insertRequest(mtoRequest);
		if(result > 0) {
			request.setAttribute("alertMsg", "요청에 성공했습니다.");
			response.sendRedirect(request.getContextPath() + "/portfolio?no=" + refPno);
		}
	}
}
