package com.coursemonitoringsystem.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

	private static String drivername;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle rs = ResourceBundle.getBundle("dbdetails");
		drivername = rs.getString("db.drivername");
		url = rs.getString("db.url");
		username = rs.getString("db.username");
		password = rs.getString("db.password");
	}
	
	
	public static Connection provideConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}















