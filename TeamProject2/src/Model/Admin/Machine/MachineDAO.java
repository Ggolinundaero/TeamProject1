package Model.Admin.Machine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utility.DBManager;

public class MachineDAO {
	private MachineDAO() {}
	private static MachineDAO instance = new MachineDAO();
	public static MachineDAO getInstance() {
		return instance;
	}
	
	// count
	public int machine_count() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;
		String query = "select count(*) from BC_MACHINE";
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
	
	public int machine_count(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int row = 0;
		String query = "select count(*) as counter from BC_MACHINE";
		
		try {
			conn = DBManager.getConnection();
			if (s_query.equals("")) {
				query = "";
			} else {
				query = "select count(*) as counter from BC_MACHINE where " + s_query;
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

	public List<MachineVO> machine_list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from BC_MACHINE";
		List<MachineVO> list = new ArrayList();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MachineVO vo = new MachineVO();
				vo.setMachine_code(rs.getString("machine_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setGame_name(rs.getString("game_name"));
				vo.setMachine_model(rs.getString("machine_model"));
				vo.setRenter_chk(rs.getString("renter_chk"));
				vo.setTuning_chk(rs.getString("tuning_chk"));
				vo.setBroken_chk(rs.getString("broken_chk"));
				vo.setPlay_fee(rs.getInt("play_fee"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<MachineVO> machine_list(String s_query) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from BC_MACHINE where " + s_query;
		List<MachineVO> list = new ArrayList();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			MachineVO vo = null;
			while (rs.next()) {
				vo = new MachineVO();
				vo.setMachine_code(rs.getString("machine_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setGame_name(rs.getString("game_name"));
				vo.setMachine_model(rs.getString("machine_model"));
				vo.setRenter_chk(rs.getString("renter_chk"));
				vo.setTuning_chk(rs.getString("tuning_chk"));
				vo.setBroken_chk(rs.getString("broken_chk"));
				vo.setPlay_fee(rs.getInt("play_fee"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 해당 기기코드를 입력한 결과를 select 
	public List<MachineVO> lever_select(int machine_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		String query = "select * from BC_MACHINE where machine_code =?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, machine_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MachineVO vo = new MachineVO();
				vo.setMachine_code(rs.getString("machine_code"));
				vo.setCompany_name(rs.getString("company_name"));
				vo.setGame_name(rs.getString("game_name"));
				vo.setMachine_model(rs.getString("machine_model"));
				vo.setRenter_chk(rs.getString("renter_chk"));
				vo.setTuning_chk(rs.getString("tuning_chk"));
				vo.setBroken_chk(rs.getString("broken_chk"));
				vo.setPlay_fee(rs.getInt("play_fee"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}	
}
