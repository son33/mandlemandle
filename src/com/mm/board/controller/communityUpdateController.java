package com.mm.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.board.model.vo.BoardDivide;
import com.mm.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class communityUpdateController
 */
@WebServlet("/update.co")
public class communityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public communityUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service =  new BoardServiceImpl();

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Board b = service.searchBoard(boardNo);
		
		Member m = (Member)request.getSession().getAttribute("loginUser");
		if(m == null || m.getUserNo() != b.getUserNo()) {
			request.getSession().setAttribute("alertMsg", "잘못된 접근입니다.");
			response.sendRedirect("detail.co?bno="+boardNo);
		}
		ArrayList<BoardDivide> list = service.selectBoardDivideList();
		
		request.setAttribute("list", list);
		request.setAttribute("b", b);
		request.setAttribute("status", "update");
		
		request.getRequestDispatcher("WEB-INF/views/board/communityInsert.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int boardNo = Integer.parseInt(multi.getParameter("boardNo"));
			int boardDivideNo = Integer.parseInt(multi.getParameter("boardDivideNo"));
			String boardTitle = multi.getParameter("boardTitle");
			String boardContent = multi.getParameter("boardContent");
			
			new Board();
			Board b = Board.builder()
					.boardNo(boardNo)
					.boardContent(boardContent)
					.boardTitle(boardTitle)
					.boardDivideNo(boardDivideNo)
					.build();
			
			Attachment at = null;
			
			if(multi.getOriginalFileName("reUpfile") != null) {
				at = new Attachment();
				at.setOriginName(multi.getOriginalFileName("reUpfile"));
				at.setChangeName(multi.getFilesystemName("reUpfile"));
				at.setFilePath("resources/board_upfiles/");
				
				if(multi.getParameter("originFileNo") != null) {
					at.setFileNo(Integer.parseInt(multi.getParameter("originFileNo")));
				
					new File(savePath+multi.getParameter("originFileName")).delete();
				}else {
					at.setRefBno(boardNo);
				}
			}
			
			int result = new BoardServiceImpl().updateBoard(b);
					
			if(result > 0) {
				//수정성공시
				request.getSession().setAttribute("alertMsg", "성공적으로 수정 되었습니다.");
				response.sendRedirect("detail.co?bno="+boardNo);
			}else {
				//수정실패시
				request.setAttribute("errorMsg", "게시글 수정에 실패했습니다.");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
		}
	}

}
