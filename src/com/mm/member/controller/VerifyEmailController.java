package com.mm.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.member.model.service.MemberService;
import com.mm.member.model.service.MemberServiceImpl;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class VerifyEmailController
 */
@WebServlet("/verifyEmail")
public class VerifyEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		String email = request.getParameter("email");
		boolean check = false;
        Member verifyEmail = service.verifyEmail(email);
        if(verifyEmail == null) {
        	check = true;
        }
        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(check));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
