package board;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbctest.OracleConnection;

public class BoardTest5 {

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static String sql;
	private static ResultSet rs;
	private static Properties prop;
	
	BoardTest5() {
		conn = OracleConnection.getConnection();
		prop = new Properties();
		try {
			prop.load(new FileReader(new File("C:/Users/admin/git/study/JDBCTest/src/prop/sql.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			BoardTest5 boardTest5 = new BoardTest5();
			List<Board> boardList = boardTest5.listBoard();
			System.out.println(boardList);
			/*
			Board board = boardTest5.selectBoard(4);
			int result1 = boardTest5.insertBoard(new Board(0, "작성자", "제목", "내용"));
			int result2 = boardTest5.updateBoard(new Board(5, "수정작성자", "수정제목", "수정내용"));
			int result3 = boardTest5.deleteBoard(5);
			*/
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, pstmt, rs);
		}
		
	} // main
	
	// 1. list
	List<Board> listBoard() throws SQLException {
		sql = prop.getProperty("list");
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Board> boardList = new ArrayList<Board>();
		
		while(rs.next()) {
			boardList.add(new Board(rs.getInt("bid"), rs.getString("bwriter"), rs.getString("btitle"), rs.getString("bcontent")));
		}
		
		return boardList;
	}
	
	// 2. select
	Board selectBoard(int bid) throws SQLException {
		sql = prop.getProperty("select");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		rs = pstmt.executeQuery();
		Board board = new Board(rs.getInt("bid"), rs.getString("bwriter"), rs.getString("btitle"), rs.getString("bcontent"));
		return board;
	}
	
	// 3. insert
	int insertBoard(Board board) throws SQLException {
		sql = prop.getProperty("insert");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBwriter());
		pstmt.setString(2, board.getBtitle());
		pstmt.setString(3, board.getBcontent());
		return pstmt.executeUpdate();
	}
	
	// 4. update
	int updateBoard(Board board) throws SQLException{
		sql = prop.getProperty("update");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getBwriter());
		pstmt.setString(2, board.getBtitle());
		pstmt.setString(3, board.getBcontent());
		pstmt.setInt(4, board.getBid());
		return pstmt.executeUpdate();
	}
	
	// 5. delete
	int deleteBoard(int bid) throws SQLException{
		sql = prop.getProperty("delete");
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(4, bid);
		return pstmt.executeUpdate();
	}
	
} // class
