<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션사용 예제</title>
</head>
<body>
	<%
		Enumeration en = session.getAttributeNames();
	while (en.hasMoreElements()) {
		String name = (String) en.nextElement();
		String value = (String) session.getAttribute(name);
		out.println("sesson name : " + name + "<br>");
		out.println("sesson value : " + value + "<br>");
	}
	%>
	---------------------<br/>
	<%
		Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; ++i) {
	%>
	Cookie Name:
	<%=cookies[i].getName()%><br> 
	Cookie Value :
	<%=cookies[i].getValue()%><br>
	<%
		}
	}
	%>
</body>
</html>