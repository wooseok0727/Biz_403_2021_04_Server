package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String username = "gbUser";
		String password = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("MySQL 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("=".repeat(30));
			System.out.println("jdbcDriver를 찾을 수 없습니다");
			System.out.println("jdbcDriver : " + jdbcDriver);
			System.out.println("=".repeat(30));
		} catch (SQLException e) {
			System.out.println("=".repeat(30));
			System.out.println("MySQL 연동 오류");
			System.out.println("url : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			System.out.println("=".repeat(30));
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
