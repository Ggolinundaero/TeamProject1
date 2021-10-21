package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.53:49161:xe","jsl49","1234");
			//Mysql일경우
	//		Class.forName("com.mysql.jdbc.Driver");
		//	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:db이름","계정","비번");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
//	public static Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:apache:commons:dbcp:oracledb");
//	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		}catch(Exception e) {}
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			conn.close();
			pstmt.close();
		}catch(Exception e) {}
	}
}
