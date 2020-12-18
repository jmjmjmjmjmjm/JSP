<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos.test1.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾아보기</title>
</head>
<body>
	<%
		String sql = "SELECT * FROM users";
	Connection conn = DBConn.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	int id;
	String username;
	String password;
	String email;

	while (rs.next()) {
		id = rs.getInt("id");
		username = rs.getString("username");
		password = rs.getString("password");
		email = rs.getString("email");
	%>
	<h1><%=id%></h1>
	<h1><%=username%></h1>
	<h1><%=password%></h1>
	<h1><%=email%></h1>
	<%
		}
	%>




</body>
</html>