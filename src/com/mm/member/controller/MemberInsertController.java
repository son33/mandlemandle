package com.mm.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mm.common.AESCryptor;
import com.mm.member.model.service.MemberServiceImpl;
import com.mm.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet(urlPatterns="/insert.me", name="insertServlet")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String birth = request.getParameter("birth");
		birth = birth.replaceAll("-", "").substring(2);
		String gender = (request.getParameter("gender") != null) ? request.getParameter("gender") : "";
		String phone = request.getParameter("phone");
		int zipcode = Integer.parseInt(request.getParameter("zipCode"));
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = (request.getParameter("address3") != null) ? request.getParameter("address3") : "";
		int memberDivideNo = Integer.parseInt(request.getParameter("memberDivideNo"));
		
		Member m = Member.builder().email(email).userPwd(userPwd).userName(userName).birth(birth).gender(gender).phone(phone).zipcode(zipcode).address1(address1).address2(address2).address3(address3).memberDivideNo(memberDivideNo).build();
		int result = new MemberServiceImpl().insertMember(m);
		HttpSession session = request.getSession();
		if(result > 0) {
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/login.me");
		} else {
			session.setAttribute("alertMsg", "회원가입에 실패했습니다. 다시 가입해주세요.");
			response.sendRedirect(request.getContextPath()+"/login.me");
		}
	}
}
