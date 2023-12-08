package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbctest.OracleConnection;

public class BoardTest3 {
	
	public static void main(String[] args) {
		
		Connection conn = OracleConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;
		
		try {
			/*
			// 1. insert
			sql = " insert into board values (seq_board.nextval, ?, ?, ?) "; // 자바의 문법
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "유관순1");
			pstmt.setString(2, "제목");
			pstmt.setString(3, "내용");
			result = pstmt.executeUpdate();
			if (result>0) System.out.println("입력 성공!");
			*/
			
			// 2. update (실습)
			sql = " update board set btitle=?, bcontent=? where bid=9 ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "수정된 제목");
			pstmt.setString(2, "수정된 내용");
			result = pstmt.executeUpdate();
			if (result>0) System.out.println("입력 성공!");
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, pstmt, null);
		}
		
	}
	
}
