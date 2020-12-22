package ch12;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnectionMgr {
	boolean initialized = false;

	public static Connection getInstance() {// new할 필요가 없기에 static
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클url검색하면 나옴.
		String username = "SCOTT";
		String password = "TIGER";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 모든 클래스 다 사용가능
			conn = DriverManager.getConnection(url, username, password);// 바이트 스트림에 연결
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}
		return null;
	}

	public synchronized Connection getConnection() throws Exception {
		if (!initialized) {
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver((Driver) c.newInstance());
			initialized = true;
		}
		return null;

	}
}