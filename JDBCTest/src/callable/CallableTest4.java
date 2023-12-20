package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbctest.OracleConnection;
import oracle.jdbc.OracleTypes;

public class CallableTest4 {

	Connection conn;
	CallableStatement cstmt;
	ResultSet rs;
	
	public CallableTest4() {
		
		conn = OracleConnection.getConnection();
		String sql = " {call PROC_CALL_CUR(?, ?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, 50);
			// 2번째 out parameter로 오라클커서를 받는다.
			// oracle.jdbc.oracletypes.cursor 타입을 사용, 이 타입은 초반에 연결한 oracle 라이브러리에 있는거
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			// execute, executeupdate 다 똑같은거임 근데, insert, update, delete 한거 수 받으려면 update 쓰는거
			cstmt.execute();
			// 결과로 받은 커서를 ResultSet으로 형변환
			rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				System.out.println(
						rs.getInt("EMPLOYEE_ID")+ " " +
						rs.getString("FIRST_NAME")+ " " +
						rs.getString("LAST_NAME")
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CallableTest4();
	}
	
}
