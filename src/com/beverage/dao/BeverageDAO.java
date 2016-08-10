package com.beverage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beverage.dto.BeverageDTO;

public class BeverageDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static BeverageDAO dao = new BeverageDAO();

	private BeverageDAO() {

	}

	public static BeverageDAO getInstance() {
		if (dao == null)
			dao = new BeverageDAO();
		return dao;
	}

	private Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		String username = "hr";
		String password = "a1234";
		return DriverManager.getConnection(url, username, password);
	}// end init()

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
	}// end stop()

	public void cafeInsert(String cafe_name) {

		try {
			conn = init();
			String sql = "insert into b_cafe(cafe_id, cafe_name) values(SEQ_b_cafe_cafe_id.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cafe_name);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cafeDeverageInsert(int cafe_id, BeverageDTO dto) {

		try {
			conn = init();
			String sql = "insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)"
					+ " values(SEQ_b_beverage_beverage_id.nextval, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cafe_id);
			pstmt.setInt(2, dto.getBeverage_price());
			pstmt.setString(3, dto.getBeverage_type());
			pstmt.setString(4, dto.getBeverage_name());
			pstmt.setString(5, dto.getBeverage_text());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}// end class
