package com.beverage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.beverage.dto.BeverageDTO;
import com.beverage.dto.ReviewDTO;
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

	// 카페 정보 등록
	public void cafeInsert(String cafe_name) {
		try {
			conn = init();
			String sql = "insert into b_cafe(cafe_id, cafe_name) values(SEQ_b_cafe_cafe_id.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cafe_name);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}// end cafeInsert()

	// 등록된 카페 정보 가지고 오기
	public void cafeSelect() {
		try {
			conn = init();
			String sql = "select * from b_cafe";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDTO.getInstance().getCafe_map().put(rs.getInt("cafe_id"), rs.getString("cafe_name"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
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
		} finally {
			stop();
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
	}// end idCheck()

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

		return Math.round(avg * 100) / (double) 100;
	}

	public ArrayList<BeverageDTO> beverageSearch(String name, String price) {
		ArrayList<BeverageDTO> arr = new ArrayList<BeverageDTO>();

		String[] strarr = price.split("~");

		try {
			conn = init();

			String sql = "select * from b_beverage where beverage_type =? " + " and beverage_price >= ?"
					+ "and beverage_price <= ?" + " order by beverage_price";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			if (price == "전체") {
				pstmt.setInt(2, 0);
				pstmt.setInt(3, 10000);
			} else {
				pstmt.setInt(2, Integer.parseInt(strarr[0]));
				pstmt.setInt(3, Integer.parseInt(strarr[1]));
			}
			// pstmt.setString(1, "%" + serch.toLowerCase() + "%");
			// pstmt.setString(2, serch);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BeverageDTO dto = new BeverageDTO();
				dto.setBeverage_id(rs.getInt("beverage_id"));
				dto.setCafe_id(rs.getInt("cafe_id"));
				dto.setBeverage_price(rs.getInt("beverage_price"));
				dto.setBeverage_type(rs.getString("beverage_type"));
				dto.setBeverage_name(rs.getString("beverage_name"));
				dto.setBeverage_text(rs.getString("beverage_text"));
				arr.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return arr;
	}

}// end class
