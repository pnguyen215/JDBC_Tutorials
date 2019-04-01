package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseStatements {

	public CreateDatabaseStatements() {
	}

	public static void createDatabase() {
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "create database dbinternet";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			System.out.println("Database created successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		createDatabase();
	}

}
