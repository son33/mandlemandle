package com.mm.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.jjim.model.service.JjimServiceImpl;
import com.mm.jjim.model.vo.Jjim;
import com.mm.member.model.vo.Member;
import com.mm.request.model.service.RequestServiceImpl;
import com.mm.request.model.vo.Request;

/**
 * Servlet implementation class mentorMypage
 */
@WebServlet("/menteeMypage")
public class menteeMypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menteeMypageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		int memberDivideNo = 0;
		
		if(loginUser != null) {
			memberDivideNo = loginUser.getMemberDivideNo();
		}
		if (loginUser == null || memberDivideNo != 3) {
			request.getSession().setAttribute("alertMsg", "잘못된 접근입니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			int mtiNo = loginUser.getUserNo();
			if(boardNo == 1) {
				ArrayList<Jjim> jjimList = new JjimServiceImpl().getJjimList(mtiNo);
				request.setAttribute("jjimList", jjimList);
			}
			if(boardNo == 2 ) {
				new Request();
				Request menteeRequest = Request.builder().mtiNo(mtiNo).mtoNo(0).build();
				ArrayList<Request> requestList = new RequestServiceImpl().getRequestList(menteeRequest);
				request.setAttribute("user", "맨티");
				request.setAttribute("requestList", requestList);
			}
			if(boardNo == 3) {
				ArrayList<Board> communityBoardList = new BoardServiceImpl().getCommunityBoardList(mtiNo);
				ArrayList<Reply> communityReplyList = new BoardServiceImpl().getCommunityReplyList(mtiNo);
				request.setAttribute("boardList", communityBoardList);
				request.setAttribute("replyList", communityReplyList);
			}
		}
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("loginUser", loginUser);
		request.getRequestDispatcher("WEB-INF/views/mentee/menteeMypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
