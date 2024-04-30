package com.mm.area.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.area.model.service.AreaService;
import com.mm.area.model.service.AreaServiceImpl;
import com.mm.area.model.vo.Sigungu;

/**
 * Servlet implementation class SigunguSelectController
 */
@WebServlet("/sigungu.sg")
public class SigunguSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigunguSelectController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AreaService service = new AreaServiceImpl();
		int sidoNo = Integer.parseInt(request.getParameter("sidoNo"));
		ArrayList<Sigungu> sidoList = service.getSigungu(sidoNo);
		
		request.setAttribute("sidoList", sidoList);
		String jsonReviewList = new Gson().toJson(sidoList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(jsonReviewList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
