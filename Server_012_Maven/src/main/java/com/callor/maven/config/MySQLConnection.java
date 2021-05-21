package com.callor.maven.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/guestbook";
		String username = "gbUser";
		String password = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			System.out.println("MySQL 접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("=".repeat(20));
			System.out.println("jdbcDriver를 찾을 수 없습니다");
			System.out.println("jdbcDriver : " + jdbcDriver);
			System.out.println("=".repeat(20));
		} catch (SQLException e) {
			System.out.println("=".repeat(20));
			System.out.println("MySQL 접속 실패");
			System.out.println("접속정보를 확인하세요");
			System.out.println("-".repeat(20));
			System.out.println("url : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			System.out.println("=".repeat(20));
		}		
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
}
