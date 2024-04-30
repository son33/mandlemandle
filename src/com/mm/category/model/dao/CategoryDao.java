package com.mm.category.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.category.model.vo.BigCategory;
import com.mm.category.model.vo.SubCategory;

public class CategoryDao {

	public ArrayList<SubCategory> allCategory(SqlSession session) {
		return new ArrayList<SubCategory> (session.selectList("categoryMapper.allCategory"));
	}

	public ArrayList<SubCategory> searchCategoryList(SqlSession session, String search) {
		return new ArrayList<SubCategory> (session.selectList("categoryMapper.searchCategoryList",search));
	}

	public ArrayList<BigCategory> getBigCategory(SqlSession session) {
		return new ArrayList<BigCategory> (session.selectList("categoryMapper.selectBigCategory"));
	}

	public ArrayList<SubCategory> getSubCategory(SqlSession session, int categoryNo) {
		return new ArrayList<SubCategory> (session.selectList("categoryMapper.selectSubCategory",categoryNo));
	}
}
