package com.cos.test1.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/ssar1?serverTimezone=Asia/Seoul";
		String username = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("DB 연결 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB 연결 실패");
		return null;
	}
}
