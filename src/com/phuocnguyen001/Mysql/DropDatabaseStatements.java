package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDatabaseStatements {

	public DropDatabaseStatements() {
	}

	public static void dropDatabase() {

		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "drop database person";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			System.out.println("Database deleted successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		dropDatabase();
	}

}
