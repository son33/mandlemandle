package com.mm.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mm.board.model.service.BoardService;
import com.mm.board.model.service.BoardServiceImpl;
import com.mm.board.model.vo.Board;
import com.mm.common.model.vo.PageInfo;
import com.mm.common.template.Pagination;

/**
 * Servlet implementation class communityFilterController
 */
@WebServlet("/filter.co")
public class communityFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public communityFilterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardServiceImpl();
	    String condition = request.getParameter("condition");
	    
	    int boardDivideNo = Integer.parseInt(request.getParameter("boardNo"));
	    int	listCount = service.selectListCount(boardDivideNo);
	    
	    int pageLimit = 10;
	    int boardLimit = 5;
	    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
	    PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
	    ArrayList<Board> list = service.selectList(pi,condition,boardDivideNo);

	    JsonObject jsonObject = new JsonObject();
	    Gson gson = new Gson();

	    String jsonPi = gson.toJson(pi);
	    JsonParser jsonParser = new JsonParser();
	    JsonObject piObject = (JsonObject) jsonParser.parse(jsonPi);
	    jsonObject.add("pi", piObject);

	    String jsonList = gson.toJson(list);
	    JsonArray listArray = (JsonArray) jsonParser.parse(jsonList);
	    jsonObject.add("list", listArray);

	    String jsonString = gson.toJson(jsonObject);
	    response.setContentType("application/json;charset=UTF-8");
	    response.getWriter().write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
