package com.mm.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.board.model.vo.Board;
import com.mm.category.model.vo.SubCategory;
import com.mm.main.model.service.MainService;
import com.mm.main.model.service.MainServiceImpl;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MainService service = new MainServiceImpl();
    	ArrayList<SubCategory> mainCategoryList = service.getMainCategoryList();
    	ArrayList<Board> communityList1 = service.getCommunityList1();
    	ArrayList<Board> communityList2 = service.getCommunityList2();
    	ArrayList<Portfolio> recommendList = service.getRecommendList();
    	ArrayList<Review> liveReviewList = service.getLiveReviewList();
    	request.setAttribute("mainCategoryList", mainCategoryList);
    	request.setAttribute("communityList1", communityList1);
    	request.setAttribute("communityList2", communityList2);
    	request.setAttribute("recommendList", recommendList); 
    	request.setAttribute("liveReviewList", liveReviewList);
    	
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}