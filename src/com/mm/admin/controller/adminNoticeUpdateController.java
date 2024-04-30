package com.mm.admin.controller;

import java.io.File;
import java.io.IOException;

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
 * Servlet implementation class adminNoticeUpdateController
 */
@WebServlet("/adminNoticeUpdate")
public class adminNoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminNoticeUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = request.getServletContext().getRealPath("/resources/notice_upfiles/");
        int userNo = 1;
        int boardNo = 0;  
        MultipartRequest multi = new MultipartRequest(request, filePath, 20 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
        boardNo = Integer.parseInt(multi.getParameter("boardNo"));
        String updateTitle = multi.getParameter("boardTitle");
        String updateContent = multi.getParameter("boardContent");

        adminBoardService service = new adminBoardServiceImpl();
        
        Board b = new Board();
        b.setBoardTitle(updateTitle);
        b.setBoardContent(updateContent);
        b.setUserNo(userNo);

        try {
            b.setBoardNo(Integer.parseInt(multi.getParameter("boardNo")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write("{ \"success\": false, \"message\": \"게시글 수정 실패\", \"data\": \"Invalid updateNo\" }");
            return;
        }

        Attachment at = null;

        if (multi.getOriginalFileName("reupfile") != null) {
        	at = new Attachment();
			at.setOriginName(multi.getOriginalFileName("reupfile"));
			at.setChangeName(multi.getFilesystemName("reupfile"));
			at.setFilePath("resources/notice_upfiles/");

			if(multi.getParameter("originFileNo") != null && !multi.getParameter("originFileNo").isEmpty()) {
				at.setFileNo(Integer.parseInt(multi.getParameter("originFileNo")));
				new File(filePath+multi.getParameter("originFileName")).delete();
			}else {
				at.setRefBno(boardNo);
			}
        }
        int result = service.updateNotice(b,at);

        response.setContentType("application/json; charset=UTF-8");
        if (result > 0) {
            Gson gson = new Gson();
            String json = gson.toJson(b);
            response.getWriter().write("{ \"success\": true, \"message\": \"게시글 수정 성공\", \"data\": " + json + "}");
        } else {
            response.getWriter().write("{ \"success\": false, \"message\": \"게시글 수정 실패\" }");
        }
    }
}


