package board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbctest.OracleConnection;

public class BoardTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = OracleConnection.getConnection();
			stmt = conn.createStatement();
			int result = 0;
			
			/*
			// 1. insert
			String insertSql 
				= " insert into board values(seq_board.nextval, '홍길동', '제목1', '내용1') ";
			result = stmt.executeUpdate(insertSql); // 영향 받은 행의 수를 return
			if(result>0) System.out.println("입력 성공!");
			*/
			
			/*
			// 2. update
			String updateSql
				= " update board set bcontent='수정된 내용' where bid=1 ";
			result = stmt.executeUpdate(updateSql);
			if(result>0) System.out.println("수정 성공!");
			*/
			
			/*
			// 3. delete 
			String deleteSql
			= " delete board where bid=1 ";
			result = stmt.executeUpdate(deleteSql);
			if(result>0) System.out.println("삭제 성공!");
			*/
			
			// 실습 : 데이터 3건 입력하고 리스트를 출력해 봅시당!
			/*
			for(int i=1; i<4; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(" insert into board values (seq_board.nextval");
				sb.append(", '홍길동"+i);
				sb.append("', '제목"+i);
				sb.append("', '내용"+i+"') ");
				String insertSql = sb.toString();
				result = stmt.executeUpdate(insertSql);
			}	
			*/	
						
			String sql =" select BID, BWRITER, BTITLE, BCONTENT from board "; 
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bwriter = rs.getString("bwriter");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				System.out.println(bid  + ", " + bwriter + ", " + btitle + ", " + bcontent + ", ");
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			OracleConnection.closeConnection(conn, stmt, rs);
		}
		
	} // main
	
} // class
