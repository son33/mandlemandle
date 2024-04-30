package com.mm.main.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.board.model.vo.Board;
import com.mm.category.model.vo.SubCategory;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public class MainDao {
	public ArrayList<SubCategory> getMainCategoryList(SqlSession session) {
		return new ArrayList<SubCategory>(session.selectList("categoryMapper.getMainCategoryList"));
	}
	
	public ArrayList<Board> getCommunityList1(SqlSession session) {
		return new ArrayList<Board>(session.selectList("boardMapper.getCommunityList1"));
	}
	public ArrayList<Board> getCommunityList2(SqlSession session) {
		return new ArrayList<Board>(session.selectList("boardMapper.getCommunityList2"));
	}

	public ArrayList<Portfolio> getRecommendList(SqlSession session) {
		return new ArrayList<Portfolio>(session.selectList("portfolioMapper.getRecommendList"));
	}

	public ArrayList<Review> getLiveReviewList(SqlSession session) {
		return new ArrayList<Review>(session.selectList("portfolioMapper.getLiveReviewList"));
	}
}
