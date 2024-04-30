package com.mm.request.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.member.model.vo.Member;
import com.mm.request.model.service.RequestService;
import com.mm.request.model.service.RequestServiceImpl;
import com.mm.request.model.vo.Request;

/**
 * Servlet implementation class acceptRequestController
 */
@WebServlet("/request.ac")
public class acceptRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acceptRequestController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl();
		int requestNo = Integer.parseInt(request.getParameter("requestNo"));
		Member member = (Member) request.getSession().getAttribute("loginUser");
		int mtoNo = member.getUserNo();
		int result = service.acceptRequest(requestNo);
		if(result > 0) {
			request.setAttribute("alertMsg", "수락하였습니다");
			new Request();
			Request menteeRequest = Request.builder().mtoNo(mtoNo).mtiNo(0).build();
			ArrayList<Request> requestList = new RequestServiceImpl().getRequestList(menteeRequest);
			request.setAttribute("user", "mentor");
			request.setAttribute("requestList", requestList);
		} else {
			request.setAttribute("alertMsg", "수락에 실패했습니다. 다시 시도해주세요.");
		}
		response.sendRedirect(request.getContextPath()+"/mentorMypage?boardNo=2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
