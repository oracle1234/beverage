package com.beverage.dao;

import java.sql.*;
import java.util.HashMap;

import com.beverage.dto.BeverageDTO;
import com.beverage.dto.MemberDTO;

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
			e.printStackTrace();
		}
	}// end cafeInsert()

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
			e.printStackTrace();
		}
		return cafe_map;
	}// end cafeSelect()

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
			e.printStackTrace();
		}
	}// end cafeBeverageInsert()

	// 로그인 & 정보 불러오기
	public boolean getMember(String id, String password) {
		MemberDTO dto = MemberDTO.getInstance();
		boolean ok = false;
		try {
			conn = init();
			String sql = "SELECT * FROM b_member WHERE member_id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			if (pstmt != null) {
				rs = pstmt.executeQuery();
				while (rs.next()) {
					dto.setMember_num(rs.getInt("member_num"));
					dto.setName(rs.getString("name"));
					dto.setGender(rs.getString("gender"));
					dto.setEmail(rs.getString("email"));
					dto.setBirth_date(rs.getDate("birth_date"));
					dto.setMember_id(rs.getString("member_id"));
					dto.setPassword(rs.getString("password"));
					ok = true;
				}
			} else
				ok = false;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return ok;
	}// end getMember()

	// 회원가입
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;

		try {
			conn = init();
			String sql = "INSERT INTO b_member(member_num,name,gender,email,birth_date,member_id,password) "
					+ "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMember_num());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getEmail());
			pstmt.setDate(5, dto.getBirth_date());
			pstmt.setString(6, dto.getMember_id());
			pstmt.setString(7, dto.getPassword());
			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				ok = true;
			} else {
				ok = false;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return ok;
	}// end insertMember()

	// 회원정보 수정
	public boolean updateMember(MemberDTO updto) {
		boolean ok = false;
		try {
			conn = init();
			String sql = "UPDATE b_member SET member_num =?,name=?,gender=?,email=?,birth_date=? "
					+ "WHERE member_id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updto.getMember_num());
			pstmt.setString(2, updto.getName());
			pstmt.setString(3, updto.getGender());
			pstmt.setString(4, updto.getEmail());
			pstmt.setDate(5, updto.getBirth_date());
			pstmt.setString(6, updto.getMember_id());
			pstmt.setString(7, updto.getPassword());
			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				ok = true;
			} else {
				ok = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return ok;
	}// end updateMember()

	// 회원탈퇴
	public boolean deleteMember(String id, String password) {
		boolean ok = false;
		try {
			conn = init();
			String sql = "DELETE FROM b_member WHERE member_id=? AND password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			int rs = pstmt.executeUpdate();

			if (rs > 0) {
				ok = true;
			} else {
				ok = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return ok;
	}// end deleteMember()

}// end class
