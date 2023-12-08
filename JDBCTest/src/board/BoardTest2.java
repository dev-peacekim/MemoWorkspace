package board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbctest.OracleConnection;

public class BoardTest2 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = OracleConnection.getConnection();
			stmt = null;
			int result = 0;
			String sql = null;
			
			/*
			// 1. insert
			Board board = new Board(0, "강감찬", "제목100", "내용100");
			sql = " insert into board values (seq_board.nextval, ";
			sql += "'" + board.getBwriter() + "', ";
			sql += "'" + board.getBtitle() + "', ";
			sql += "'" + board.getBcontent() + "') ";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			if(result>0) System.out.println("입력 성공!");
			*/
			
			// 2. select
			List<Board> boardList = new ArrayList<Board>();
			sql = " select bid, bwriter, btitle, bcontent from board ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board board2 = new Board();
				board2.setBid(rs.getInt("bid"));
				board2.setBwriter(rs.getString("bwriter"));
				board2.setBtitle(rs.getString("btitle"));
				board2.setBcontent(rs.getString("bcontent"));
				boardList.add(board2);
			}
			
			if(boardList!=null) {
				for(Board board3 : boardList) {
					System.out.println(
							board3.getBid() + ", " +
							board3.getBwriter() + ", " +
							board3.getBtitle() + ", " +
							board3.getBcontent()
							
					);
				}
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, stmt, rs);
		}
		
		
	} // main
	
} // class
