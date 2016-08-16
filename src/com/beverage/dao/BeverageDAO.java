package com.beverage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.beverage.dto.BeverageDTO;

import com.beverage.dto.FavorDTO;

import com.beverage.dto.CafeDTO;

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
	public int cafeInsert(String cafe_name) {
		int count = 0;
		try {
			conn = init();
			String sql = "insert into b_cafe(cafe_id, cafe_name) values(SEQ_b_cafe_cafe_id.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cafe_name);
			count = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return count;
	}// end cafeInsert()

	// 카페 정보 삭제
	public void cafeDelete(String cafe) {
		try {
			conn = init();
			String sql = "delete from b_cafe where cafe_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cafe);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}

	// 등록된 카페 정보 가지고 오기
	public void cafeSelect() {
		ArrayList<CafeDTO> aList = new ArrayList<CafeDTO>();
		MemberDTO.getInstance().getCafeList().removeAll(MemberDTO.getInstance().getCafeList());
		try {
			conn = init();
			String sql = "select * from b_cafe order by cafe_id";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				CafeDTO dto = new CafeDTO();
				dto.setCafe_id(rs.getInt("cafe_id"));
				dto.setCafe_name(rs.getString("cafe_name"));
				MemberDTO.getInstance().getCafeList().add(dto);
				MemberDTO.getInstance().getCafe_map().put(rs.getInt("cafe_id"), rs.getString("cafe_name"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}// end

	// 카페에 음료 추가하기
	public int cafeBeverageInsert(BeverageDTO dto) {
		int cnt = 0;
		try {
			conn = init();
			String sql = "insert into b_beverage(beverage_id, cafe_id, beverage_price, beverage_type, beverage_name, beverage_text)"
					+ " values(SEQ_b_beverage_beverage_id.nextval, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCafe_id());
			pstmt.setInt(2, dto.getBeverage_price());
			pstmt.setString(3, dto.getBeverage_type());
			pstmt.setString(4, dto.getBeverage_name());
			pstmt.setString(5, dto.getBeverage_text());
			cnt = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
		return cnt;
	}// end cafeBeverageInsert()

	// 음료 삭제하기 - 리뷰까지 전부 삭제
	public void cafeBeverageDelete(int beverage_id) {

		try {
			conn = init();
			String sql = "delete from b_beverage where beverage_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beverage_id);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}

	// 관리자 페이지 음료 전부 불러오기
	public ArrayList<BeverageDTO> allBeverageSearch() {
		ArrayList<BeverageDTO> arr = new ArrayList<BeverageDTO>();

		try {
			conn = init();

			String sql = "select * from b_beverage order by beverage_price";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

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

	// 관리자 페이지 리뷰 삭제
	public void reviewDelete(int beverage_id, String member_id) {
		try {
			conn = init();
			String sql = "delete from b_review where beverage_id = ? and member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beverage_id);
			pstmt.setString(2, member_id);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stop();
		}
	}

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
					+ "values(SEQ_b_member_member_num.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
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
			String sql = "UPDATE b_member SET email=?, password=? " + "WHERE member_id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updto.getEmail());
			pstmt.setString(2, updto.getPassword());
			pstmt.setString(3, updto.getMember_id());

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

	// 리뷰 등록
	public int reviewInsert(int beverage_id, String member_id, String beverage_review, int review_level) {

		int cnt = 0;
		try {
			conn = init();

			String sql = "insert into b_review(beverage_id, member_id, beverage_review, review_level) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, beverage_id);
			pstmt.setString(2, member_id);
			pstmt.setString(3, beverage_review);
			pstmt.setInt(4, review_level);

			cnt = pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return cnt;

	}// end insertMethod

	// 리뷰 리스트
	public ArrayList<ReviewDTO> searchMethod(int id) {

		ArrayList<ReviewDTO> aList = new ArrayList<ReviewDTO>();

		try {
			conn = init();

			String sql = "select member_id, beverage_review , review_level from b_review where beverage_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setMember_id(rs.getString("member_id"));
				dto.setReview_level(rs.getInt("review_level"));
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

	// 음료 평점
	public double levelMethod(int b_id) {
		double avg = 0;

		ArrayList<ReviewDTO> aList = new ArrayList<ReviewDTO>();
		try {
			conn = init();
			String sql = "select avg(review_level) from b_review where beverage_id = ? group by beverage_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_id);
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

	// 즐겨 찾기 리스트
	public boolean favoerCheck(int beverage_id) {
		boolean is_check = false;
		try {
			conn = init();
			String sql = "select * from b_favor where member_num=? and beverage_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MemberDTO.getInstance().getMember_num());
			pstmt.setInt(2, beverage_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				is_check = true;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return is_check;
	}

	// 메인 음료 검색
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

	// 즐겨찾기 추가
	public void favorInsert(int member_num, int beverage_id, String cafe_name, String beverage_name,
			int beverage_price) {

		try {
			conn = init();

			String sql = "insert into b_favor values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, member_num);
			pstmt.setInt(2, beverage_id);
			pstmt.setString(3, cafe_name);
			pstmt.setString(4, beverage_name);
			pstmt.setInt(5, beverage_price);

			pstmt.executeQuery();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

	}// end insertMethod

	// 즐겨 찾기 리스트
	public ArrayList<FavorDTO> favorSearch() {
		ArrayList<FavorDTO> fav = new ArrayList<FavorDTO>();

		try {
			conn = init();
			String sql = "select * from b_favor where member_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MemberDTO.getInstance().getMember_num());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FavorDTO dto = new FavorDTO();
				dto.setBeverage_id(rs.getInt("beverage_id"));
				dto.setCafe_name(rs.getString("cafe_name"));
				dto.setBeverage_name(rs.getString("beverage_name"));
				dto.setBeverage_price(rs.getInt("beverage_price"));
				fav.add(dto);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}

		return fav;
	}

	// 즐겨찾기 삭제
	public void favorDel(int id) {
		try {
			conn = init();
			String sql = "delete from b_favor where beverage_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
	}

	// 즐겨찾기에서 리뷰로
	public BeverageDTO favoerToReview(int beverage_id) {
		BeverageDTO dto = new BeverageDTO();
		try {
			conn = init();
			String sql = "select b.beverage_id, b.cafe_id, b.beverage_price, b.beverage_type, b.beverage_name, b.beverage_text"
					+ " from b_favor f, b_beverage b" + " where f.beverage_id = b.beverage_id and b.beverage_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beverage_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setBeverage_id(rs.getInt("beverage_id"));
				dto.setCafe_id(rs.getInt("cafe_id"));
				dto.setBeverage_price(rs.getInt("beverage_price"));
				dto.setBeverage_type(rs.getString("beverage_type"));
				dto.setBeverage_name(rs.getString("beverage_name"));
				dto.setBeverage_text(rs.getString("beverage_text"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stop();
		}
		return dto;
	}

}// end class
