package com.mm.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.attachment.model.service.AttachmentServiceImpl;
import com.mm.attachment.model.vo.Attachment;
import com.mm.jjim.model.service.JjimServiceImpl;
import com.mm.jjim.model.vo.Jjim;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.service.PortfolioService;
import com.mm.portfolio.model.service.PortfolioServiceImpl;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;
import com.mm.request.model.service.RequestServiceImpl;
import com.mm.request.model.vo.Request;

/**
 * Servlet implementation class PortfolioController
 */
@WebServlet("/portfolio")
public class PortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PortfolioController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PortfolioService service = new PortfolioServiceImpl();
		int ptfNo = Integer.parseInt(request.getParameter("no"));
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");

		Portfolio portfolio = service.getPortfolio(ptfNo);
		ArrayList<Attachment> attachmentList = new AttachmentServiceImpl().portfolioAttachmentList(ptfNo);
		int mtoNo = 0;
		int mtiNo = 0;
		if(loginUser != null && loginUser.getMemberDivideNo() == 3) {
			mtoNo = portfolio.getMtoNo();
			mtiNo = loginUser.getUserNo();
			Request rq = Request.builder().mtiNo(mtiNo).mtoNo(mtoNo).build();
			Request mentorRequest = new RequestServiceImpl().getMentorRequest(rq);
			if(mentorRequest != null) {
				request.setAttribute("mentorRequest", mentorRequest);
			}
			Jjim jj = Jjim.builder().mtiNo(mtiNo).mtoNo(mtoNo).build();
			Jjim jjim = new JjimServiceImpl().getJjim(jj);
			if(jjim != null) {
				request.setAttribute("jjim", jjim);
			}
			Review rv = Review.builder().refPno(ptfNo).userNo(mtiNo).build();
			Review review = service.getReview(rv);
			if(review != null) {
				request.setAttribute("review", review);
			}
		}
		
		request.setAttribute("user", "맨티");
		request.setAttribute("portfolio", portfolio);
		request.setAttribute("attachmentList", attachmentList);
		request.getRequestDispatcher("WEB-INF/views/memberCommon/portfolioView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
