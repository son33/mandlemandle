package com.mm.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.portfolio.model.service.PortfolioService;
import com.mm.portfolio.model.service.PortfolioServiceImpl;
import com.mm.portfolio.model.vo.Review;

/**
 * Servlet implementation class InsertReviewController
 */
@WebServlet("/insert.rv")
public class InsertReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewController() {
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
		PortfolioService service = new PortfolioServiceImpl();
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
        int refPno = Integer.parseInt(request.getParameter("refPno"));
        int userNo = Integer.parseInt(request.getParameter("userNo"));
        int score = Integer.parseInt(request.getParameter("score"));
        
        new Review();
		Review review = Review.builder().reviewTitle(reviewTitle).reviewContent(reviewContent).refPno(refPno).userNo(userNo).score(score).build();
        int result = service.insertReview(review);
        if(result > 0) {
        	request.setAttribute("alertMsg", "리뷰가 성공적으로 등록되었습니다.");
        } else {
        	request.setAttribute("alertMsg", "리뷰 작성에 실패했습니다. 다시 시도해주세요.");
        }
	}
}
