package com.beverage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beverage.dto.MemberDTO;

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
			rs = pstmt.executeQuery();
			dto.setMember_num(rs.getInt("member_num"));
			dto.setName(rs.getString("name"));
			dto.setGender(rs.getString("gender"));
			dto.setEmail(rs.getString("email"));
			dto.setBirth_date(rs.getDate("birth_date"));
			dto.setMember_id(rs.getString("member_id"));
			dto.setPassword(rs.getString("password"));
			ok = true;

		} catch (SQLException | ClassNotFoundException e) {
			ok = false;
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
					+ "values(SEQ_b_member_member_num.NEXTVAL,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// pstmt.setInt(1, dto.getMember_num());
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getEmail());
			pstmt.setDate(4, dto.getBirth_date());
			pstmt.setString(5, dto.getMember_id());
			pstmt.setString(6, dto.getPassword());
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

	// 아이디 중복체크
	public boolean idCheck(String id) {
		boolean check = false;
		try {
			conn = init();
			String sql = "SELECT member_id FROM b_member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString("member_id"))) {
					check = true;
					break;
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return check;
	}

}// end class
