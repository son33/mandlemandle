package com.mm.category.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.category.model.dao.CategoryDao;
import com.mm.category.model.vo.BigCategory;
import com.mm.category.model.vo.SubCategory;
import com.mm.common.template.Template;

public class CategoryServiceImpl implements CategoryService{
	
	private CategoryDao categoryDao = new CategoryDao();

	@Override
	public ArrayList<SubCategory> allCategory() {
		SqlSession session = Template.getSqlSession();
		ArrayList<SubCategory> list = categoryDao.allCategory(session);
		session.close();
		return list;
	}

	@Override
	public ArrayList<SubCategory> searchCategoryList(String search) {
		SqlSession session = Template.getSqlSession();
		ArrayList<SubCategory> list = categoryDao.searchCategoryList(session, search);
		session.close();
		return list;
	}

	public ArrayList<BigCategory> getBigCategory() {
		SqlSession session = Template.getSqlSession();
		ArrayList<BigCategory> list = categoryDao.getBigCategory(session);
		session.close();
		return list;
	}

	@Override
	public ArrayList<SubCategory> getSubCategory(int categoryNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<SubCategory> list = categoryDao.getSubCategory(session, categoryNo);
		session.close();
		return list;
	}
}
