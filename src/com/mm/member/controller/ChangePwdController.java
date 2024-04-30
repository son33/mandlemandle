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
 * Servlet implementation class changePwdController
 */
@WebServlet(urlPatterns="/changePwd", name="changePwdServlet")
public class ChangePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m == null) {
			request.getSession().setAttribute("alertMsg", "잘못된 접근입니다.");
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		Member m = (Member)request.getSession().getAttribute("m");
		Member changePwd = (Member)request.getSession().getAttribute("m");
		String userPwd = request.getParameter("userPwd");
		changePwd.setUserPwd(userPwd);
		request.getSession().removeAttribute("m");
		int result = service.changePwd(changePwd);
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "비밀번호 변경에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/login.me");
		} else {
			request.setAttribute("m", m);
			request.setAttribute("alertMsg", "비밀번호 변경에 실패했습니다. 다시시도해주세요.");
			request.getRequestDispatcher("WEB-INF/views/enroll/changePwd.jsp").forward(request, response);
		}
	}

}
