package com.beverage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (dao == null)
			dao = new MemberDAO();

		return dao;
	}

	private Connection init() throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";

		return DriverManager.getConnection(url, username, password);
	}

	private void stop() {

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
