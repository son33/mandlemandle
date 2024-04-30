package com.mm.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.co")
public class communityDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public communityDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int result = service.countList(boardNo);
		
		HttpSession session = request.getSession();
		if(result > 0) {
			Board b = service.searchBoard(boardNo);
			request.setAttribute("b", b);
			request.getRequestDispatcher("WEB-INF/views/board/communityDetail.jsp").forward(request, response);
		}else {
			session.setAttribute("alertMsg", "게시글 상세조회 실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
