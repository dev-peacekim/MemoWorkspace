package jdbctest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class OracleConnection {
	
	private static Connection conn;
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(new FileReader(new File("C:/Users/admin/git/study/JDBCTest/src/prop/dbconn.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final String JDBC_URL = prop.getProperty("JDBC_URL");
	private static final String JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
	private static final String JDBC_USER = prop.getProperty("JDBC_USER");
	private static final String JDBC_PWD = prop.getProperty("JDBC_PWD");
	
	
	public static void main(String[] args) {
		
		
	} // main
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PWD);
			
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
