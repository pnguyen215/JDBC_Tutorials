package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public JDBCConnection() {
	}

	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/managestudent";
		final String user = "root";
		final String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
