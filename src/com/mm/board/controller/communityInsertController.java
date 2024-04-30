package com.mm.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.BoardDivide;
import com.mm.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.co")
public class communityInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public communityInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDivide> list = service.selectBoardDivideList();
		
		request.setAttribute("list", list);
		request.setAttribute("status", "insert");
		request.getRequestDispatcher("WEB-INF/views/board/communityInsert.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 1;
        request.setCharacterEncoding("UTF-8");
        String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
        int maxSize = 50 * 1024 * 1024; // 50MB

        MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
                new DefaultFileRenamePolicy());

        int boardDivideNo = Integer.parseInt(multiRequest.getParameter("boardDivideNo"));
        String boardTitle = multiRequest.getParameter("boardTitle");
        String boardContent = multiRequest.getParameter("boardContent");
        int userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();

        new Board();
        Board board = Board.builder()
        		.boardContent(boardContent)
        		.boardTitle(boardTitle)
                .boardDivideNo(boardDivideNo)
                .userNo(userNo)
                .build();
			if (multiRequest.getOriginalFileName("upfile") != null) {
				new Attachment();
				Attachment at = Attachment.builder().originName(multiRequest.getOriginalFileName("upfile"))
				.changeName(multiRequest.getFilesystemName("upfile")).filePath("/resources/board_upfiles/")
				.fileType(1).fileLevel(1).build();
				result = service.insertBoard(board, at);
			} else {
				result = service.insertBoard(board);
			}
        if (result > 0) {
            request.getSession().setAttribute("alertMsg", "게시글 작성에 성공했습니다.");
            response.sendRedirect("community?boardNo=1&page=1");
        } else {
	        request.getSession().setAttribute("alertMsg", "게시글 작성에 실패했습니다.");
	        response.sendRedirect("community?boardNo=1&page=1");
        }
    }
}
