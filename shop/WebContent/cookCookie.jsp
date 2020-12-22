<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cook Cookie</title>
</head>
<% 
	String cookieName= "myCookie";	 //쿠키 이름넣기
	Cookie cookie = new Cookie(cookieName,"Apple");	//쿠키생성. 쿠키이름은mycookie가되고 쿠키값은Apple
	cookie.setMaxAge(60);	//쿠키가 60초의 생성을가짐
	cookie.setValue("Melone"); //쿠키에 멜론이라는 값을 설정
	response.addCookie(cookie); //클라이언트로 쿠키전송
%>
<body>
	<h1>Example Cookie</h1>
	쿠키를 만듭니다 <br>
	쿠키내용은 <a href="tasteCookie.jsp">여기로</a>!!!
	
	
</body>
</html>