package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
// 자바 x로시작하는 패키지는 톰켓이 들고있는 라이브러리.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserController extends HttpServlet {

	// req,res는 톰켓이 만들어줌. (사용자의 요청이 있을때만.)
	// req는 BufferedReader 할수있는 ByteStream
	// res는 BufferedWriter 할수있는 ByteStream

	// http://localhost:8000/hello/user?gubun=login
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("프론트 컨트롤러 실행됨");

		String gubun = req.getParameter("gubun");
		System.out.println(gubun);

		if (gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");
		} else if (gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if (gubun.equals("selectOne")) {
			resp.sendRedirect("user/selectOne.jsp");
		} else if (gubun.equals("updateOne")) {
			resp.sendRedirect("user/updateOne.jsp");
		}
		doProcess(req, resp);

	}
	// post요청은 FORM태그 만들고 요청 = INSERT,DELETE,UPDATE
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("userController post요청");
			doProcess(request, response);
		}

		protected void doProcess(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("UserProcess process요청");
		}
}
