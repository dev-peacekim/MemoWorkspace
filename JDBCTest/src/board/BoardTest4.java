package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbctest.OracleConnection;

public class BoardTest4 {

	public static void main(String[] args) {
		
		// 실습) BoardTest3의 코드를 Board를 사용하는 코드로 반환
		Connection conn = OracleConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;
		
		try {
			
			/*
			// 2. update
			Board board = new Board();
			board.setBtitle("수정된 제목2");
			board.setBcontent("수정된 내용2");
			
			sql = " update board set btitle=?, bcontent=? where bid=9 ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			result = pstmt.executeUpdate();
			if (result>0) System.out.println("입력 성공!");
			*/
			
			// 3. list
			sql = " select bid, bwriter, btitle, bcontent from board ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Board> boardList = new ArrayList<Board>();
			
			while(rs.next()) {
				boardList.add(new Board(rs.getInt("bid"), rs.getString("bwriter"), rs.getString("btitle"), rs.getString("bcontent")));
			}
			
			for(Board board : boardList) {
				System.out.println(
						board.getBid() + board.getBwriter() + board.getBtitle() + board.getBcontent()
				);
			}
			
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, pstmt, rs);
		}
		
	} // main
	
} // class
