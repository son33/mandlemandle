package com.mm.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.area.model.service.AreaServiceImpl;
import com.mm.area.model.vo.Sido;
import com.mm.attachment.model.service.AttachmentServiceImpl;
import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.category.model.service.CategoryServiceImpl;
import com.mm.category.model.vo.BigCategory;
import com.mm.member.model.vo.Member;
import com.mm.portfolio.model.service.PortfolioServiceImpl;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.request.model.service.RequestServiceImpl;
import com.mm.request.model.vo.Request;

/**
 * Servlet implementation class mentorMypage
 */
@WebServlet("/mentorMypage")
public class mentorMypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mentorMypageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int memberDivideNo = 0;
		
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		int mtoNo = 0;
		if(loginUser != null) {
			memberDivideNo = loginUser.getMemberDivideNo();
		}
		if (loginUser == null || memberDivideNo != 2) {
			request.getSession().setAttribute("alertMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
		} else {
			mtoNo = loginUser.getUserNo();
			if(boardNo == 1) {
				Portfolio portfolio = new PortfolioServiceImpl().mentorGetPortfolio(mtoNo);
				request.setAttribute("portfolio", portfolio);
				ArrayList<Attachment> attachmentList = new AttachmentServiceImpl().getAttachmentList(mtoNo);
				request.setAttribute("attachmentList", attachmentList);
				ArrayList<BigCategory> bigCategory = new CategoryServiceImpl().getBigCategory();
				request.setAttribute("bigCategory", bigCategory);
				ArrayList<Sido> sido = new AreaServiceImpl().getSido();
				request.setAttribute("sido", sido);
			}
			if(boardNo == 2) {
				new Request();
				Request menteeRequest = Request.builder().mtoNo(mtoNo).build();
				ArrayList<Request> requestList = new RequestServiceImpl().getRequestList(menteeRequest);
				request.setAttribute("user", "맨토");
				request.setAttribute("requestList", requestList);
			}
			if(boardNo == 3) {
				ArrayList<Board> communityBoardList = new BoardServiceImpl().getCommunityBoardList(mtoNo);
				ArrayList<Reply> communityReplyList = new BoardServiceImpl().getCommunityReplyList(mtoNo);
				request.setAttribute("boardList", communityBoardList);
				request.setAttribute("replyList", communityReplyList);
			}
		}
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("loginUser", loginUser);
		request.getRequestDispatcher("WEB-INF/views/mentor/mentorMypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
