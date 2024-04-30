package com.mm.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Reply;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class ReplyInsertController2
 */
@WebServlet("/insert.re")
public class ReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service =  new BoardServiceImpl();
		
		String replyContent = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Member m = (Member)request.getSession().getAttribute("loginUser");
		int userNo = m.getUserNo();
		
		Reply reply = Reply.builder().boardNo(boardNo).replyContent(replyContent).userNo(userNo).build();
		
		int result = service.insertReply(reply);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
