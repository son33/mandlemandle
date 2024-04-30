package com.mm.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.admin.model.service.adminBoardService;
import com.mm.admin.model.service.adminBoardServiceImpl;
import com.mm.attachment.model.vo.Attachment;
import com.mm.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class adminFAQInsertController
 */
@WebServlet("/adminFAQInsert")
public class adminFAQInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminFAQInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getServletContext().getRealPath("/resources/notice_upfiles/");
		
		int userNo =1;
		MultipartRequest multi = new MultipartRequest(request,filePath,20*1024*1024,"UTF-8",
				new DefaultFileRenamePolicy());
		
		
		String boardTitle = multi.getParameter("boardTitle");
		String boardContent = multi.getParameter("boardContent");
		Enumeration e = multi.getFileNames();
		while(e.hasMoreElements()) {
			String fileName = (String)e.nextElement();
		}
		adminBoardService service = new adminBoardServiceImpl();
		
		Board b = new Board();
			
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setUserNo(userNo);
		
		Attachment at = null;
		if(multi.getOriginalFileName("upfile") != null) {
			at = new Attachment();
			at.setOriginName(multi.getOriginalFileName("upfile"));
			at.setChangeName(multi.getFilesystemName("upfile"));
			at.setFilePath("resources/notice_upfiles/");
		}
		int result = service.FAQInsert(b,at);
		
		if(result>0) {
			Gson gson = new Gson();
			String json = gson.toJson(b);
			response.setContentType("application/json; charset=UTF-8");
		    response.getWriter().write("{ \"success\": true, \"message\": \"게시글 작성 성공\", \"data\": " + json + "}");
		}else {
			response.setContentType("application/json; charset=UTF-8");
		    response.getWriter().write("{ \"success\": false, \"message\": \"게시글 작성 실패\" }");
			
		    if(at!=null) {
				new File(filePath+at.getChangeName()).delete();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
