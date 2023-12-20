package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbctest.OracleConnection;

public class CallableTest2 {

	Connection conn;
	CallableStatement cstmt;
	
	public CallableTest2() {
		conn = OracleConnection.getConnection();
		String sql = " {?=call FUNC_CALL(?, ?)} ";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setInt(2, 10);
			cstmt.setInt(3, 20);
			cstmt.executeUpdate();
			System.out.println(cstmt.getInt(1));
			OracleConnection.closeConnection(conn, cstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CallableTest2();
	}
	
}
