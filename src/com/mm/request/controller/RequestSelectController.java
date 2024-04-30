package com.mm.request.controller;

import java.io.IOException;

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
 * Servlet implementation class RequestSelectController
 */
@WebServlet("/request")
public class RequestSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSelectController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestService service = new RequestServiceImpl();
		
		int requestNo = Integer.parseInt(request.getParameter("requestNo"));
		
		Member member = (Member) request.getSession().getAttribute("loginUser");
		int userNo = member.getUserNo();
		int memberDivideNo = member.getMemberDivideNo();
		
		Request mentorRequest = new Request().builder().requestNo(requestNo).build();
		if(memberDivideNo == 2) {
			mentorRequest.setMtoNo(userNo);
			mentorRequest.setMtiNo(0);
			Request requestResult = service.selectRequest(mentorRequest);
			if(requestResult == null) {
				request.setAttribute("alertMsg", "잘못된 요청입니다"); 
			}
			request.setAttribute("request", requestResult);
			request.setAttribute("user", "mentor");
			
		} else if(memberDivideNo == 3) {
			mentorRequest.setMtiNo(userNo);
			mentorRequest.setMtoNo(0);
			Request requestResult = service.selectRequest(mentorRequest);
			if(requestResult == null) {
				request.setAttribute("alertMsg", "잘못된 요청입니다");
			}
			request.setAttribute("request", requestResult);
			request.setAttribute("user", "mentee");
		} else {
			Request requestResult = service.selectRequest(mentorRequest);
			request.setAttribute("user", "admin");
		}
		request.setAttribute("situation", "detail");
		request.getRequestDispatcher("WEB-INF/views/memberCommon/mentorRequestPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
