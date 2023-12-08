package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnection {
	
	// 데이터베이스 연결 인터페이스
	private static Connection conn;
	
	// Oracle JDBC URL : 연결할 오라클 DB의 경로
	// 형식 > jdbc:oracle:this:@오라클서버아이피:오라클포트번호:SID
	private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost 자리에 ip 넣어도 됨
	
	// OracleDB 드라이버 클래스 명
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; // 연결에 사용하는 드라이버 클래스
	
	// 로그인할 계정
	private static final String JDBC_USER = "no341251";
	private static final String JDBC_PWD = "1234";
	
	
	public static void main(String[] args) {
		
		
	} // main
	
	public static Connection getConnection() {
		
		try {
			
			// 데이터베이스 드라이버 클래스를 메모리에 로딩 (클래스 로딩 타임에)
			Class.forName(JDBC_DRIVER); 
			
			// 데이터베이스 커넥션 획득 (conn이 null이 아니면 접속된 것!)
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
			
			/*
			// DB에 보낼 쿼리문 (습관적으로 앞 뒤에 공백 하나씩 넣어주면 좋다), 세미콜론 안넣음 알아서 넣음
			String sql =" select employee_id, emp_name from employees "; 
			
			// 쿼리 인터페이스 - 쿼리 객체 생성용 
			Statement stmt = conn.createStatement(); 
			
			// 쿼리문을 수행한 결과 행 집합에 대한 커서 획득 (반복자라고 생각하면 편함)
			ResultSet rs = stmt.executeQuery(sql); // 셀렉트 용 메소드
			
			// 커서를 한 행씩 이동시키면서 결과를 가져옴
			// 데이터베이스의 데이터타입과 자바의 데이터타입을 적절히 맞춰서 가져와야 함
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String empName = rs.getString("emp_name");
				System.out.println(employeeId + ", " + empName);
			}
			*/
			
			return conn;
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		} 
		
	} // getConnection
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
	
} // class
