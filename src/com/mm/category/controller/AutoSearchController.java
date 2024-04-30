package com.mm.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mm.category.model.service.CategoryService;
import com.mm.category.model.service.CategoryServiceImpl;
import com.mm.category.model.vo.SubCategory;

/**
 * Servlet implementation class AutoSearchController
 */
@WebServlet("/AutoSearch")
public class AutoSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoSearchController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService service = new CategoryServiceImpl();
        String search = request.getParameter("search");
        ArrayList<SubCategory> list = service.searchCategoryList(search);
        
        JSONArray jsonArray = new JSONArray();
        for (SubCategory cv : list) {
            String categoryName = cv.getCategoryName();
            String subcategoryName = cv.getSubCategoryName();
            
            JSONObject keywordList = new JSONObject();
            keywordList.put("categoryName", categoryName);
            keywordList.put("subcategoryName", subcategoryName);
            jsonArray.add(keywordList);
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().append(jsonArray.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
