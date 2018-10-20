package com.phuocnguyen002.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public JDBCConnection() {
	}

	public static Connection getJDBCConnection() {
		final String url = "jdbc:oracle:thin:@localhost:1521:hello";
		final String user = "username";
		final String password = "password";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			Connection connection = getJDBCConnection();
			if (connection != null) {
				System.out.println("Connection successful!");
			} else {
				System.out.println("Disconnect!");
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
