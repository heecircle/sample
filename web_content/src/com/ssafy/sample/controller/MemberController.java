package com.ssafy.sample.controller;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.service.MemberServiceImpl;

@WebServlet("/user")
public class MemberController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = req.getParameter("action");
		System.out.println(action);
		String msg = null;
		if(action.equals("regist")) {
			System.out.println("?!?!?!?!?!?!");
			String id = req.getParameter("userid");
			String password = req.getParameter("userpass");
			String name = req.getParameter("username");
			int age = Integer.parseInt(req.getParameter("userage"));
			Member newMember = new Member(id, password, name, age);
			if(MemberServiceImpl.getInstance().registerUser(newMember)) {
		
				HttpSession session = req.getSession();		
				session.setAttribute("loginUser", newMember);
				msg = "로그인 성공!";
				
			}else {
				msg = "로그인 실패!";
			}
			
		}else if(action.equals("login")){
			String id = req.getParameter("userid");
			String password = req.getParameter("userpass");
			Member newMember = MemberServiceImpl.getInstance().getUserInfo(id, password);
			if(newMember == null) {
		
				HttpSession session = req.getSession();		
				session.setAttribute("loginUser", newMember);
				msg = "로그인 성공!";
				
			}else {
				msg = "로그인 실패!";
			}
		}
		req.setAttribute("msg", msg);
 		RequestDispatcher disp = req.getRequestDispatcher("index.jsp");
 		disp.forward(req, resp);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}
