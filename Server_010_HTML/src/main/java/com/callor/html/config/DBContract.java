package com.callor.html.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "myfood";
		String password = "myfood";
		
		if(dbConn == null ) {
			try {
				Class.forName(jdbcDriver);
				dbConn = DriverManager.getConnection(url, username, password);
				System.out.println("오라클 접속 완료");
			} catch (ClassNotFoundException e) {
				System.out.println("ojdbc6.jar 파일을 확인하세요");
			} catch (SQLException e) {
				System.out.println("=".repeat(20));
				System.out.println("Driver : " + jdbcDriver);
				System.out.println("url : " + url);
				System.out.println("Username : " + username);
				System.out.println("Password : " + password);
				System.out.println("=".repeat(20));
				System.out.println("오라클 DBMS 접속 오류");
				System.out.println("접속 정보를 확인하세요");
				System.out.println("=".repeat(20));
			}
		}
	} // end static
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
