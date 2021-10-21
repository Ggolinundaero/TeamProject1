package Model.Admin.Recive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utility.DBManager;

public class ReceiveDAO {
	private ReceiveDAO() {
	}

	private static ReceiveDAO instance = new ReceiveDAO();

	public static ReceiveDAO getInstance() {
		return instance;
	}

	// 입고 등록 메소드
	public int ReceiveWrite(ReceiveVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		String query = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getOrder_code()); // 발주코드
			pstmt.setString(2, vo.getAdmin()); // 작성자
			pstmt.setString(3, vo.getCompany_name()); // 회사명
			pstmt.setInt(4, vo.getAmount()); // 수량
			pstmt.setInt(5, vo.getUnit_cost()); // 상품금액
			pstmt.setInt(6, vo.getSurtax()); // 부가세
			pstmt.setInt(7, vo.getReceive_cost()); // 상품 + 부가세 다 더한 총액
			pstmt.setString(8, vo.getInsert_date()); // 입고일
			pstmt.setString(9, vo.getStock()); // 제품명
			pstmt.setString(10, vo.getModel_name()); // 모델명
			pstmt.setString(11, vo.getSangse()); // 상세
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}

	// 입고 리스트 카운트 메소드(검색없음)
	public int RecevieListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public int RecevieListCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "select count(*) as counter from pr_board ";
			} else {
				query = "select count(*) as counter from pr_board where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	// 전체 입고목록(검색없음, 페이지 없음)
	public List<ReceiveVO> ReceiveList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReceiveVO> list = new ArrayList();

		String query = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiveVO vo = new ReceiveVO();
				vo.setOrder_code(rs.getString("order_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setStock(rs.getString("stock"));
				vo.setModel_name(rs.getString("model_name"));
				vo.setUnit_cost(rs.getInt("unit_cost"));
				vo.setInsert_date(rs.getString("insert_date"));
				vo.setSangse(rs.getString("sangse"));
				vo.setAmount(rs.getInt("amount"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//물건DB
	public List<ReceiveVO> LeverList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReceiveVO> list = new ArrayList<ReceiveVO>();
		String query = "select * from bc_lever";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiveVO vo = new ReceiveVO();
				vo.setCompany(rs.getString("company"));
				vo.setL_model(rs.getString("l_model"));
				vo.setL_name(rs.getString("l_name"));
				vo.setColor(rs.getString("color"));
				vo.setParts(rs.getString("parts"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	

	// 전체 입고목록 목록(검색없음, 페이지 O)
	public List<ReceiveVO> ReceiveList(int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReceiveVO> list = new ArrayList();
		String query = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiveVO vo = new ReceiveVO();
				vo.setOrder_code(rs.getString("order_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setStock(rs.getString("stock"));
				vo.setModel_name(rs.getString("model_name"));
				vo.setUnit_cost(rs.getInt("unit_cost"));
				vo.setInsert_date(rs.getString("insert_date"));
				vo.setSangse(rs.getString("sangse"));
				vo.setAmount(rs.getInt("amount"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 전체 입고목록 목록(검색없음, 페이지 O)
	public List<ReceiveVO> ReceiveList(String s_query, int startpage, int endpage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReceiveVO> list = new ArrayList();
		String query = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReceiveVO vo = new ReceiveVO();
				vo.setOrder_code(rs.getString("order_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setStock(rs.getString("stock"));
				vo.setModel_name(rs.getString("model_name"));
				vo.setUnit_cost(rs.getInt("unit_cost"));
				vo.setInsert_date(rs.getString("insert_date"));
				vo.setSangse(rs.getString("sangse"));
				vo.setAmount(rs.getInt("amount"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public ReceiveVO ReceiveView(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		ReceiveVO vo = new ReceiveVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setOrder_code(rs.getString("order_code"));
			vo.setAdmin(rs.getString("admin"));
			vo.setCompany_name(rs.getString("company_name"));
			vo.setStock(rs.getString("stock"));
			vo.setModel_name(rs.getString("model_name"));
			vo.setAmount(rs.getInt("amount"));
			vo.setUnit_cost(rs.getInt("unit_cost"));
			vo.setSurtax(rs.getInt("surtax"));
			vo.setReceive_cost(rs.getInt("receive_cost"));
			vo.setInsert_date(rs.getString("insert_date"));
			vo.setSangse(rs.getString("sangse"));
		} catch (Exception z) {
			z.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	/*
	 * // 삭제 public int ReceiveDelete(ReceiveVO vo) { Connection conn = null;
	 * PreparedStatement pstmt = null; int row = 0; String sql = ""; try { conn =
	 * DBManager.getConnection(); pstmt = conn.prepareCall(sql); pstmt.setInt(1, );
	 * pstmt.setString(2, ); row = pstmt.executeUpdate(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { DBManager.close(conn, pstmt); } return row;
	 * }
	 */
	public int ReceiveModify(ReceiveVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		String sql = "";
		try {
			conn = DBManager.getConnection();
			pstmt.setString(1, vo.getOrder_code()); // 발주코드
			pstmt.setString(2, vo.getAdmin()); // 작성자
			pstmt.setString(3, vo.getCompany_name()); // 회사명
			pstmt.setInt(4, vo.getAmount()); // 수량
			pstmt.setInt(5, vo.getUnit_cost()); // 상품금액
			pstmt.setInt(6, vo.getSurtax()); // 부가세
			pstmt.setInt(7, vo.getReceive_cost()); // 상품 + 부가세 다 더한 총액
			pstmt.setString(8, vo.getInsert_date()); // 입고일
			pstmt.setString(9, vo.getStock()); // 제품명
			pstmt.setString(10, vo.getModel_name()); // 모델명
			pstmt.setString(11, vo.getSangse()); // 상세
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
}
