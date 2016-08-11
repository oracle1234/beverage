package com.beverage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.beverage.dto.BeverageDTO;
import com.beverage.dto.ReviewDTO;

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

	public HashMap<Integer, String> cafeSelect() {
		HashMap<Integer, String> cafe_map = new HashMap<Integer, String>();
		try {
			conn = init();
			String sql = "select * from b_cafe";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				cafe_map.put(rs.getInt("cafe_id"), rs.getString("cafe_name"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cafe_map;

	}

	public void cafeBeverageInsert(int cafe_id, BeverageDTO dto) {

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
	
	public int reviewInsert(int id, String review, int num) {
		int cnt = 0;
		try {
			conn = init();

			String sql = "insert into b_review(beverage_id, member_id, beverage_review, review_level) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			pstmt.setString(2, "eeee");
			pstmt.setString(3, review);
			pstmt.setInt(4, num);

			cnt = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return cnt;

	}// end insertMethod

	public ArrayList<ReviewDTO> searchMethod() {
		ArrayList<ReviewDTO> aList = new ArrayList<ReviewDTO>();

		try {
			conn = init();

			String sql = "select member_id, beverage_review , review_level from b_review";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setReview_levle(rs.getInt("review_level"));
				dto.setBeverage_review(rs.getString("beverage_review"));
				aList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return aList;

	}// searchMethod

	public double levelMethod() {
		double avg = 0;

		ArrayList<ReviewDTO> aList = new ArrayList<ReviewDTO>();
		try {
			conn = init();
			String sql = "select avg(review_level) from b_review group by beverage_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				avg = rs.getDouble("avg(review_level)");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return Math.round(avg*100)/(double)100;
	}
	
}// end class
