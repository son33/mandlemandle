package com.mm.main.model.service;

import java.util.ArrayList;

import com.mm.board.model.vo.Board;
import com.mm.category.model.vo.SubCategory;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public interface MainService {

	ArrayList<SubCategory> getMainCategoryList();

	ArrayList<Board> getCommunityList1();
	
	ArrayList<Board> getCommunityList2();

	ArrayList<Portfolio> getRecommendList();

	ArrayList<Review> getLiveReviewList();
}
