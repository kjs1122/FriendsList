package util;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class DBManager {
	
	
	public static Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static void close(Connection conn, PreparedStatement pstmt){
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
