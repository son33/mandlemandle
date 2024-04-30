package com.mm.portfolio.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public class PortfolioDao {

	public int insertReview(SqlSession session, Review review) {
		return session.insert("portfolioMapper.insertReview", review);
	}

	public ArrayList<Review> getReviewList(SqlSession session, int refPno) {
		return new ArrayList<Review> (session.selectList("portfolioMapper.getReviewList",refPno));
	}

	public int insertPortfolio(SqlSession session, Portfolio p) {
		return session.insert("portfolioMapper.insertPortfolio",p);
	}

	public int updatePortfolio(SqlSession session, Portfolio p) {
		return session.update("portfolioMapper.updatePortfolio",p);
	}

	public Portfolio getPortfolio(SqlSession session, int ptfNo) {
		return session.selectOne("portfolioMapper.getPortfolio",ptfNo);
	}

	public Portfolio mentorGetPortfolio(SqlSession session, int mtoNo) {
		return session.selectOne("portfolioMapper.mentorGetPortfolio",mtoNo);
	}
	
	public Review getReview(SqlSession session, Review rv) {
		return session.selectOne("portfolioMapper.getReview",rv);
	}


}
