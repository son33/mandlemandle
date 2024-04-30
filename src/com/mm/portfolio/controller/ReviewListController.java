package com.mm.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.portfolio.model.service.PortfolioService;
import com.mm.portfolio.model.service.PortfolioServiceImpl;
import com.mm.portfolio.model.vo.Review;

/**
 * Servlet implementation class ReviewListController
 */
@WebServlet("/list.rv")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PortfolioService service = new PortfolioServiceImpl();
		int refPno = Integer.parseInt(request.getParameter("refPno"));
		ArrayList<Review> reviewList = service.getReviewList(refPno);
		String jsonReviewList = new Gson().toJson(reviewList);

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
