package ch12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterMgr {
	private DBConnectionMgr pool;

	public RegisterMgr() {
		try {
			pool = (DBConnectionMgr) DBConnectionMgr.getInstance();
		} catch (Exception e) {
			System.out.println("커넥션 연결실패");
		}
	}

	public boolean loginRegister(String id, String phone) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginCon = false;

		try {
			con = pool.getConnection();
			String query = "select * from usertbl where id = ? and phone = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, phone);
			if (rs.next() && rs.getInt(1) > 0)
				loginCon = true;

		} catch (Exception ex) {
			System.out.println("Excenption" + ex);
		}
		return loginCon;

	}
}
