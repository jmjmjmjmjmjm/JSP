package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
// 자바 x로시작하는 패키지는 톰켓이 들고있는 라이브러리.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.hello.model.Users;

public class UserController extends HttpServlet {

	// req,res는 톰켓이 만들어줌. (사용자의 요청이 있을때만.)
	// req는 BufferedReader 할수있는 ByteStream
	// res는 BufferedWriter 할수있는 ByteStream

	// http://localhost:8000/hello/user?gubun=login
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("프론트 컨트롤러 실행됨");
		doProcess(req, resp);

	}

	// post요청은 FORM태그 만들고 요청 = INSERT,DELETE,UPDATE
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("userController post요청");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserProcess process요청");
		String gubun = req.getParameter("gubun");
		System.out.println(gubun);
		route(gubun, req, resp);
	}

	private void route(String gubun, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (gubun.equals("login")) {
			resp.sendRedirect("auth/login.jsp");
		} else if (gubun.equals("join")) {
			resp.sendRedirect("auth/join.jsp");
		} else if (gubun.equals("selectOne")) { // 유저정보 보기
			// 인증이 필요한 페이지
			HttpSession session = req.getSession();
			Users user = (Users) session.getAttribute("sessionUser");
			
			if (session.getAttribute("sessionUser") != null) { // 인증끝
				System.out.println("인증되었습니다.");
				System.out.println(user);
			} else {
				System.out.println("인증되지않았습니다.");
				System.out.println(user);
			}
			resp.sendRedirect("user/selectOne.jsp");

		} else if (gubun.equals("updateOne")) {
			resp.sendRedirect("user/updateOne.jsp");
		} else if (gubun.equals("joinProc")) { // 회원가입 수행해줘

			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");

			System.out.println("- - - joinProc Start - - - ");
			System.out.println(username);
			System.out.println(password);
			System.out.println(email);
			resp.sendRedirect("index.jsp");
		} else if (gubun.equals("loginProc")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			System.out.println("- - - login Process - - -");
			System.out.println(username);
			System.out.println(password);
			System.out.println("- - - login process end - - - ");

			Users user = Users.builder().id(1).username(username).build(); // 빌더패턴

			HttpSession session = req.getSession(); // 서버의 힙영역에 접근
			// session에는 사용자패스워드넣으면안됨.
			session.setAttribute("sessionUser", user);
			// 모든 응답에는 jSessionId가 쿠키로 추가된다.
			session.setAttribute("sessionKey", "9998"); // 바디에담을것
			resp.setHeader("Set-Cookie", "sessionKey=9998"); // 이름을 set-cookie 에 9998로 저장
			resp.sendRedirect("index.jsp"); // 헤더에 담을 키를 전송
		} else if (gubun.equals("selectOne")) {

		}

	}
}
