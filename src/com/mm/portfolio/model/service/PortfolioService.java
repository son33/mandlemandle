package com.mm.portfolio.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public interface PortfolioService {

	int insertReview(Review review);

	ArrayList<Review> getReviewList(int refPno);

	int insertPortfolio(Portfolio p, Map<String, Object> map);

	int updatePortfolio(Portfolio p, Map<String, Object> map);

	Portfolio getPortfolio(int ptfNo);

	Portfolio mentorGetPortfolio(int mtoNo);
	
	Review getReview(Review rv);

}
