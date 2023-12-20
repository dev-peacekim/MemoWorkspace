package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbctest.OracleConnection;

// 실습 
// 1. 부서아이디를 입력하면 부서 내 직원 수를 반환하는 function을 오라클에 생성 => FUNC_EMP_CNT
// 2. 오라클에 생성한 function을 호출해서 결과를 반환하는 자바 코드를 작성
public class CallableTest3 {

	Connection conn;
	CallableStatement cstmt;
	
	public CallableTest3() {
		conn = OracleConnection.getConnection();
		String sql = " {?=call FUNC_EMP_CNT(?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, 100);
			// execute, executeupdate 다 똑같은거임 근데, insert, update, delete 한거 수 받으려면 update 쓰는거
			cstmt.execute(); 
			System.out.println(cstmt.getInt(1));
			OracleConnection.closeConnection(conn, cstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CallableTest3();
	}
	
}
