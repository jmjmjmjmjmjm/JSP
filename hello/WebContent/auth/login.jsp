<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<body>
	<h1>Login Page</h1>
	<hr>
	<form action="/hello/user?gubun=loginProc" method="post">
		<input type="text" name="username" placeholder="username"> 
		<input type="text" name="password" placeholder="password"> 
		<button>로그인</button>
	</form>
</body>
</html>