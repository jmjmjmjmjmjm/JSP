package com.cos.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gubun = req.getParameter("gubun");
		System.out.println(gubun);

		if (gubun.equals("deleteOne")) {
			resp.sendRedirect("board/deleteOne.jsp");
		} else if (gubun.equals("insertOne")) {
			resp.sendRedirect("board/insertOne.jsp");
		} else if (gubun.equals("selectAll")) {
			resp.sendRedirect("board/selectAll.jsp");
		} else if (gubun.equals("updateOne")) {
			resp.sendRedirect("board/updateOne.jsp");
		}
		doProcess(req, resp);
	}

	// post요청은 FORM태그 만들고 요청 = INSERT,DELETE,UPDATE
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardController post요청");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardControll process요청");
	}
}
