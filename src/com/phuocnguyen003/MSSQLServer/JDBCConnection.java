package com.phuocnguyen003.MSSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public JDBCConnection() {
	}

	public static Connection getJDBCConnection() {

		final String username = "sa";
		final String password = "1109chenzhenmaivien";
		final String url = "jdbc:sqlserver://localhost:1433;databaseName=StudentDB;username=" + username + ";password="
				+ password;
		/*
		 * final String url = "jdbc:sqlserver://localhost:1433;username=" + username +
		 * ";password=" + password;
		 */

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			return DriverManager.getConnection(url);
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
