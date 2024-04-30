package com.mm.main.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.board.model.vo.Board;
import com.mm.category.model.vo.SubCategory;
import com.mm.common.template.Template;
import com.mm.main.model.dao.MainDao;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public class MainServiceImpl implements MainService{

	private MainDao mainDao = new MainDao();

	@Override
	public ArrayList<SubCategory> getMainCategoryList() {
		SqlSession session = Template.getSqlSession();
		ArrayList<SubCategory> categoryList = mainDao.getMainCategoryList(session);
		session.close();
		return categoryList;
	}

	@Override
	public ArrayList<Board> getCommunityList1() {
		SqlSession session = Template.getSqlSession();
		ArrayList<Board> communityList1 = mainDao.getCommunityList1(session);
		session.close();
		return communityList1;
	}
	
	public ArrayList<Board> getCommunityList2() {
		SqlSession session = Template.getSqlSession();
		ArrayList<Board> communityList2 = mainDao.getCommunityList2(session);
		session.close();
		return communityList2;
	}

	@Override
	public ArrayList<Portfolio> getRecommendList() {
		SqlSession session = Template.getSqlSession();
		ArrayList<Portfolio> recommendList = mainDao.getRecommendList(session);
		session.close();
		return recommendList;
	}

	@Override
	public ArrayList<Review> getLiveReviewList() {
		SqlSession session = Template.getSqlSession();
		ArrayList<Review> liveReviewList = mainDao.getLiveReviewList(session);
		session.close();
		return liveReviewList;
	}
	
}
