package com.mm.category.model.service;

import java.util.ArrayList;

import com.mm.category.model.vo.BigCategory;
import com.mm.category.model.vo.SubCategory;

public interface CategoryService {

	ArrayList<SubCategory> allCategory();

	ArrayList<SubCategory> searchCategoryList(String search);
	
	ArrayList<BigCategory> getBigCategory();
	
	ArrayList<SubCategory> getSubCategory(int categoryNo);
}
