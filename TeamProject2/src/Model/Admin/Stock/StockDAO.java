package Model.Admin.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Admin.Order.OrderVO;
import util.DBManager;

public class StockDAO {
	private StockDAO() {
	}
	private static StockDAO instance = new StockDAO();
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	
	public static StockDAO getInstance() {
		return instance;
	}
	public List<StockVO> Stock_list(){
		List<StockVO> slist = new ArrayList();
		String query = "select * from bc_stock";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StockVO vo = new StockVO();
				vo.setCompany_name(rs.getString("company_name")); //회사명
				vo.setStock(rs.getString("stock")); //재고명
				vo.setModel_name(rs.getString("model_name")); //모델명
				vo.setModel_price(rs.getInt("model_price")); //가격
				vo.setStock_amount(rs.getInt("stock_amount"));//재고량
				vo.setOption_status(rs.getString("option_status"));
				vo.setParts_status(rs.getString("parts_status"));
				vo.setResive_state(rs.getString("resive_state"));
				vo.setOrder_code(rs.getString("order_code"));
				vo.setLatest_day(rs.getString("latest_day"));
				slist.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return slist;
	}
	public List<StockVO> Stock_list(int startpage,int endpage){
		List<StockVO> slist = new ArrayList();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from bc_stock order by stock desc) A " + "where rownum <=?) X where X.rnum >=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt.setInt(1, endpage);
				StockVO vo = new StockVO();
				vo.setCompany_name(rs.getString("company_name")); //회사명
				vo.setStock(rs.getString("stock")); //재고명
				vo.setModel_name(rs.getString("model_name")); //모델명
				vo.setModel_price(rs.getInt("model_price")); //가격
				vo.setStock_amount(rs.getInt("stock_amount"));//재고량
				vo.setOption_status(rs.getString("option_status"));
				vo.setParts_status(rs.getString("parts_status"));
				vo.setResive_state(rs.getString("resive_state"));
				vo.setOrder_code(rs.getString("order_code"));
				vo.setLatest_day(rs.getString("latest_day"));
				slist.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return slist;
	}
	public List<StockVO> Stock_list(String s_query,int startpage, int endpage){
		List<StockVO> slist = new ArrayList();
		String query = "select X.* from (select rownum as rnum, A.* from "
				+ "(select * from bc_stock order by stock desc) A " + "where " + s_query
				+ " and rownum <=?) X where " + s_query + " and X.rnum >=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt.setInt(1, endpage);
				StockVO vo = new StockVO();
				vo.setCompany_name(rs.getString("company_name")); //회사명
				vo.setStock(rs.getString("stock")); //재고명
				vo.setModel_name(rs.getString("model_name")); //모델명
				vo.setModel_price(rs.getInt("model_price")); //가격
				vo.setStock_amount(rs.getInt("stock_amount"));//재고량
				vo.setOption_status(rs.getString("option_status"));
				vo.setParts_status(rs.getString("parts_status"));
				vo.setResive_state(rs.getString("resive_state"));
				vo.setOrder_code(rs.getString("order_code"));
				vo.setLatest_day(rs.getString("latest_day"));
				slist.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return slist;
	}
	public int Stock_insert(StockVO vo) {
		String query = "insert into bc_stock (company_name,stock,stock_amount,model_name,model_price,kinds,order_code,option_status,parts_status) values(?,?,?,?,?,?,?,?,?)";
		int row = 0 ; 
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getCompany_name());
			pstmt.setString(2, vo.getStock());
			pstmt.setInt(3, vo.getStock_amount());
			pstmt.setString(4, vo.getModel_name());
			pstmt.setInt(5, vo.getModel_price());
			pstmt.setString(6, vo.getKinds());
			pstmt.setString(7, vo.getOrder_code());
			pstmt.setString(8, vo.getOption_status());
			pstmt.setString(9, vo.getParts_status());
			 row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	public int Stock_count() {
		int row = 0 ;
		String query = "select count(*)from bc_stock";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row ;
	}
	public int Stock_count(String s_query) {
		int row = 0 ;
		String query = "select count(*)from bc_stock where " + s_query;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				row = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row ; 
	}
	public int Stock_modify(StockVO vo,String order_code) {
		int row = 0 ; 
		String query = "update bc_stock set stock_amount=?,resive_state=? where order_code=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getStock_amount());
			pstmt.setString(2, vo.getResive_state());
			pstmt.setString(3, order_code);
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return row;
	}
	public int Stock_delete(String order_code) {
		int row = 0 ; 
		String query="delete from bc_stock where order_code=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order_code);
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return row ;
	}
	public StockVO stockView(String order_code) {
		StockVO vo = new StockVO();
		String query = "select * from bc_stock where order_code=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setOrder_code(rs.getString("order_code"));
				vo.setStock_amount(rs.getInt("stock_amount"));
				vo.setLatest_day(rs.getString("latest_day"));
				vo.setOption_status(rs.getString("option_status"));
				vo.setParts_status(rs.getString("parts_status"));
				vo.setModel_name(rs.getString("model_name"));
				vo.setModel_price(rs.getInt("model_price"));
				vo.setKinds(rs.getString("kinds"));
				vo.setStock(rs.getString("stock"));
				vo.setCompany_name(rs.getString("company_name"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return vo;
	}
	public int update(OrderVO vo1, String order_code) {
		String query="update bc_order set resive_state =? where order_code =?";
		int row = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo1.getResive_state());
			pstmt.setString(2, order_code);
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}return row;
	}
	public OrderVO insertRe(String order_code) {
		String query ="select * from bc_order where order_code=?";
		OrderVO vo = new OrderVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setOrder_code(rs.getString("order_code"));
				vo.setKinds(rs.getString("kinds"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setStock(rs.getString("stock"));
				vo.setModel_name(rs.getString("model_name"));
				vo.setO_option(rs.getString("o_option"));
				vo.setColor(rs.getString("color"));
				vo.setAmount(rs.getInt("amount"));
				vo.setUnit_cost(rs.getInt("unit_cost"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return vo;
	}
	
}
