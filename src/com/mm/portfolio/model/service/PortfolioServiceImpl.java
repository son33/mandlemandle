package com.mm.portfolio.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.dao.AttachmentDao;
import com.mm.common.template.Template;
import com.mm.portfolio.model.dao.PortfolioDao;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public class PortfolioServiceImpl implements PortfolioService{

	private PortfolioDao portfolioDao = new PortfolioDao();
	private AttachmentDao attachmentDao = new AttachmentDao();

//	리뷰 등록	
	@Override
	public int insertReview(Review review) {
		SqlSession session = Template.getSqlSession();
		int result = portfolioDao.insertReview(session, review);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

//	리뷰 불러오기
	@Override
	public ArrayList<Review> getReviewList(int refPno) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Review> list = portfolioDao.getReviewList(session, refPno); 
		session.close();
		return list;
	}

//	포트폴리오 등록
	@Override
	public int insertPortfolio(Portfolio p, Map<String, Object> map) {
		SqlSession session = Template.getSqlSession();
		int result1 = portfolioDao.insertPortfolio(session,p);
		int result2 = attachmentDao.insertPortfolio(session,map);
		if(result1*result2 > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		System.out.println("사진 등록 service 결과 : "+result1 * result2);
		return result1 * result2;
	}

//	포트폴리오 수정
	@Override
	public int updatePortfolio(Portfolio p, Map<String, Object> map) {
		SqlSession session = Template.getSqlSession();
		int result1 = portfolioDao.updatePortfolio(session,p);
		int result2 = attachmentDao.updatePortfolio(session,map);
		if(result1 * result2 > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		System.out.println("service 포트폴리오 결과 : "+result1);
		System.out.println("service 사진등록 결과 : "+result2);
		return result1 * result2;
	}

//	포트폴리오 불러오기
	@Override
	public Portfolio getPortfolio(int ptfNo) {
		SqlSession session = Template.getSqlSession();
		Portfolio portfolio = portfolioDao.getPortfolio(session, ptfNo);
		session.close();
		return portfolio;
	}

	public Portfolio mentorGetPortfolio(int mtoNo) {
		SqlSession session = Template.getSqlSession();
		Portfolio portfolio = portfolioDao.mentorGetPortfolio(session, mtoNo);
		session.close();
		return portfolio;
	}

	@Override
	public Review getReview(Review rv) {
		SqlSession session = Template.getSqlSession();
		Review review = portfolioDao.getReview(session, rv);
		session.close();
		return review;
	}
}
