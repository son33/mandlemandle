package com.mm.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.Reply;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class communityDeleteController
 */
@WebServlet("/delete.co")
public class communityDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public communityDeleteController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int result = 0;
		
		Board b = service.searchBoard(boardNo);
		ArrayList<Reply> replyList = service.selectReply(boardNo);
		
		Member m = (Member)request.getSession().getAttribute("loginUser");
		if(m == null || m.getUserNo() != b.getUserNo()) {
			request.getSession().setAttribute("alertMsg", "잘못된 접근입니다.");
			response.sendRedirect("detail.co?bno="+boardNo);
		}
		if(replyList != null) {
			result = service.deleteBoardAndReply(boardNo);
		} else {
			result = service.deleteBoard(boardNo);
		}
		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "게시물 삭제 성공");
			response.sendRedirect(request.getContextPath()+"/community?boardNo=1&page=1");
			
		}else {
			request.getSession().setAttribute("errorMsg", "게시물 삭제에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/community?detail.co?bno="+boardNo);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
