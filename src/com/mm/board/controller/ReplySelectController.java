package com.mm.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Reply;

/**
 * Servlet implementation class ReplySelectController
 */
@WebServlet("/list.re")
public class ReplySelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySelectController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bService = new BoardServiceImpl();
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		ArrayList<Reply> replyList = bService.selectReply(boardNo);
		
		request.setAttribute("replyList", replyList);
		String jsonReplyList = new Gson().toJson(replyList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(jsonReplyList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
