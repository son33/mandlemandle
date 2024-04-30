package com.mm.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mm.member.model.service.MemberServiceImpl;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/findPwd")
public class FindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/enroll/searchPwd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = Member.builder().email(request.getParameter("email")).userName(request.getParameter("userName")).build();
		Member mem = new MemberServiceImpl().searchPwd(m);
		if(mem == null) {
			request.getSession().setAttribute("alertMsg", "이름과 이메일이 맞지않거나 혹은 가입되지않는 이메일입니다.");
			request.getRequestDispatcher("WEB-INF/views/enroll/searchPwd.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("m", mem);
			request.getRequestDispatcher("WEB-INF/views/enroll/changePwd.jsp").forward(request, response);
		}
	}
}
