package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import jdbctest.OracleConnection;

public class CallableTest {

	Connection conn;
	CallableStatement cstmt;
	ResultSet rs;
	
	public CallableTest() {
		conn = OracleConnection.getConnection();
		// CallableStatement의 sql형식
		// {call 프로스져 또는 함수명 (인자개수만큼 ?)}
		String sql = " {call PROC_CALL(?,?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			// java에서 1번 물음표(PLACE HOLDER)에 100의 값을 송신, 
			// 즉 DBMS의 PROC_CALL 프로시져는 100의 값을 수신
			cstmt.setInt(1, 100);
			// java에서 2번 place holder를 out파라미터로 등록, 등록할 때 타입을 잘 매핑해주어야 함
			// oracle이라면...
			// number > integer, long
			// char, varchar2> string
			// date > timestamp, DATE
			cstmt.registerOutParameter(2, Types.INTEGER);
			// callableStatement 실행 (실행을 해야 값을 받아올 수 있음)
			cstmt.executeUpdate();
			int deptid= cstmt.getInt(2);
			System.out.println(deptid);
			OracleConnection.closeConnection(conn, cstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // constructor
	
	public static void main(String[] args) {
		new CallableTest();
	}
	
} // class
