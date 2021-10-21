package Model.Admin.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utility.DBManager;

public class OrderDAO {
	private OrderDAO() {
	}

	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

//레버시작
	// 레버 리스트
	public int leverListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from bc_totalparts";
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

	public int leverListCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) as counter from bc_totalparts";
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "";
			} else {
				query = "select count(*) as counter from bc_totalparts where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<OrderVO> LeverList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setColor(rs.getString("color"));
				vo.setT_option(rs.getString("t_option"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색
	public List<OrderVO> LeverList(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts where " + s_query;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO vo = null;
			while (rs.next()) {
				vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setColor(rs.getString("color"));
				vo.setT_option(rs.getString("t_option"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

//레버 끝
//버튼ac 시작
	public int bc_button_acListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from bc_totalparts";
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

	public int bc_button_acListCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) as counter from bc_totalparts";
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "";
			} else {
				query = "select count(*) as counter from bc_totalparts where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<OrderVO> bc_button_acList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색
	public List<OrderVO> bc_button_acList(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts where " + s_query;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO vo = null;
			while (rs.next()) {
				vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

//버튼ac끝
	// 버튼rg 시작
	public int bc_button_rgListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from bc_totalparts";
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

	public int bc_button_rgListCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) as counter from bc_totalparts";
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "";
			} else {
				query = "select count(*) as counter from bc_totalparts where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<OrderVO> bc_button_rgList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색
	public List<OrderVO> bc_button_rgList(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts where " + s_query;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO vo = null;
			while (rs.next()) {
				vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

//버튼rg 끝
//파츠시작
	public int bc_totalpartsListCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from bc_totalparts";
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

	public int bc_totalpartsListCount(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) as counter from bc_totalparts";
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "";
			} else {
				query = "select count(*) as counter from bc_totalparts where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}

	public List<OrderVO> bc_totalpartsList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				vo.setT_option(rs.getString("t_option"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색
	public List<OrderVO> bc_totalpartsList(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from bc_totalparts where " + s_query;
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO vo = null;
			while (rs.next()) {
				vo = new OrderVO();
				vo.setCompany(rs.getString("company"));
				vo.setT_name(rs.getString("t_name"));
				vo.setT_model(rs.getString("t_model"));
				vo.setPrice(rs.getInt("price"));
				vo.setT_option(rs.getString("t_option"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
