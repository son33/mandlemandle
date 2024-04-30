package com.mm.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mm.category.model.service.CategoryService;
import com.mm.category.model.service.CategoryServiceImpl;
import com.mm.category.model.vo.SubCategory;

/**
 * Servlet implementation class SelectSubCateogryController
 */
@WebServlet("/subcategory.sc")
public class SelectSubCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSubCategoryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService service = new CategoryServiceImpl();
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		ArrayList<SubCategory> subCategoryList = service.getSubCategory(categoryNo);
		
		String jsonReviewList = new Gson().toJson(subCategoryList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(jsonReviewList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
