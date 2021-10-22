package Model.Admin.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class OrderDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private OrderDAO() {
	}

	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

	// 총수 계산
	public int orderCount() {
		String query = "select count(*) from bc_totalparts";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
			return row;
		}
	}

	// 게시물의 총수를 구하는 메소드(검색조건 포함)
	public int orderCount(String s_query) {
		String query = "";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "select count(*) as counter from bc_totalparts ";
			} else {
				query = "select count(*) as counter from bc_totalparts where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
			return row;
		}
	}

	// 게시글 전체 목록 구하기
	public List<OrderVO> orderList() {
		String query = "select * from bc_totalparts";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setKinds(rs.getString("kinds"));
				order.setCompany(rs.getString("company"));
				order.setT_name(rs.getString("t_name"));
				order.setT_model(rs.getString("t_model"));
				order.setT_option(rs.getString("t_option"));
				order.setPrice(rs.getInt("price"));
				order.setColor(rs.getString("color"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 페이지별 데이터 검색
	public List<OrderVO> orderList(int pagestart, int endpage) {
		String query = "select X.* from (select rownum as rnum, A.* from " + " (select * from bc_totalparts) A "
				+ "	where rownum <= ?) X where X.rnum >= ?";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setKinds(rs.getString("kinds"));
				order.setCompany(rs.getString("company"));
				order.setT_name(rs.getString("t_name"));
				order.setT_model(rs.getString("t_model"));
				order.setT_option(rs.getString("t_option"));
				order.setPrice(rs.getInt("price"));
				order.setColor(rs.getString("color"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색 + 페이지별 데이터 검색
	public List<OrderVO> orderList(String s_query, int pagestart, int endpage) {
		String query = "select X.* from (select rownum as rnum, A.* from " + " (select * from bc_totalparts) A where "
				+ s_query + "	and rownum <= ?) X where " + s_query + " and  X.rnum >= ?";
		List<OrderVO> list = new ArrayList<OrderVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setKinds(rs.getString("kinds"));
				order.setCompany(rs.getString("company"));
				order.setT_name(rs.getString("t_name"));
				order.setT_model(rs.getString("t_model"));
				order.setT_option(rs.getString("t_option"));
				order.setPrice(rs.getInt("price"));
				order.setColor(rs.getString("color"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public int orderinsert(OrderVO order) {
		String query = "insert into bc_order(order_code, kinds,company_name,o_option,color,model_name,stock,amount,unit_cost,order_date)\r\n" + 
				"values (concat(concat(to_char(sysdate, 'YYMMDD'), '-'), to_char(BC_ORDER_SEQ.nextval)), ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order.getKinds());
			pstmt.setString(2, order.getCompany_name()); //회사명
			pstmt.setString(3, order.getO_option()); //옵션
			pstmt.setString(4, order.getColor()); //색상
			pstmt.setString(5, order.getModel_name()); //모델명
			pstmt.setString(6, order.getStock()); //제품명
			pstmt.setInt(7,  order.getAmount());
			pstmt.setInt(8,  order.getUnit_cost());
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return row;
	}
	//-------------------------발주 현황 확인 -----------------------------
	// 총수 계산
	public int order_listCount() {
		String query = "select count(*) from bc_order";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
			return row;
		}
	}

	// 게시물의 총수를 구하는 메소드(검색조건 포함)
	public int order_listCount(String s_query) {
		String query = "";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "select count(*) as counter from bc_order ";
			} else {
				query = "select count(*) as counter from bc_order where " + s_query;
			}
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next())
				row = rs.getInt("counter");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
			return row;
		}
	}

	// 게시글 전체 목록 구하기
	public List<OrderVO> order_List() {
		String query = "select * from bc_order order by order_code desc";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setOrder_code(rs.getString("order_code"));
				order.setKinds(rs.getString("kinds"));
				order.setCompany_name(rs.getString("company_name"));
				order.setStock(rs.getString("stock"));
				order.setModel_name(rs.getString("model_name"));
				order.setO_option(rs.getString("o_option"));
				order.setUnit_cost(rs.getInt("unit_cost"));
				order.setColor(rs.getString("color"));
				order.setAmount(rs.getInt("amount"));
				order.setResive_state(rs.getString("resive_state"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 페이지별 데이터 검색
	public List<OrderVO> order_List(int pagestart, int endpage) {
		String query = "select X.* from (select rownum as rnum, A.* from " + " (select * from bc_order order by order_code desc) A "
				+ "	where rownum <= ?) X where X.rnum >= ?";
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setOrder_code(rs.getString("order_code"));
				order.setKinds(rs.getString("kinds"));
				order.setCompany_name(rs.getString("company_name"));
				order.setStock(rs.getString("stock"));
				order.setModel_name(rs.getString("model_name"));
				order.setO_option(rs.getString("o_option"));
				order.setUnit_cost(rs.getInt("unit_cost"));
				order.setColor(rs.getString("color"));
				order.setAmount(rs.getInt("amount"));
				order.setResive_state(rs.getString("resive_state"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 게시글 검색 + 페이지별 데이터 검색
	public List<OrderVO> order_List(String s_query, int pagestart, int endpage) {
		String query = "select X.* from (select rownum as rnum, A.* from " + " (select * from bc_order order by order_code desc) A where "
				+ s_query + "	and rownum <= ?) X where " + s_query + " and  X.rnum >= ?";
		List<OrderVO> list = new ArrayList<OrderVO>();

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, pagestart);
			rs = pstmt.executeQuery();
			OrderVO order = null;
			while (rs.next()) {
				order = new OrderVO();
				order.setOrder_code(rs.getString("order_code"));
				order.setKinds(rs.getString("kinds"));
				order.setCompany_name(rs.getString("company_name"));
				order.setStock(rs.getString("stock"));
				order.setModel_name(rs.getString("model_name"));
				order.setO_option(rs.getString("o_option"));
				order.setUnit_cost(rs.getInt("unit_cost"));
				order.setColor(rs.getString("color"));
				order.setAmount(rs.getInt("amount"));
				order.setResive_state(rs.getString("resvie_state"));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}
