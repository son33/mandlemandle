package com.mm.category.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.category.model.service.CategoryService;
import com.mm.category.model.service.CategoryServiceImpl;
import com.mm.category.model.vo.SubCategory;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CategoryController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService service = new CategoryServiceImpl();
        ArrayList<SubCategory> list = service.allCategory();
        HashSet<String> hs = new HashSet<String>();

        for (SubCategory c : list) {
        	hs.add(c.getCategoryName());
		}
        ArrayList<String> bigCategoryNameList = new ArrayList<String>(hs);
        
        request.setAttribute("list", list);
        request.setAttribute("nameList", bigCategoryNameList);
        request.getRequestDispatcher("WEB-INF/views/common/category.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
