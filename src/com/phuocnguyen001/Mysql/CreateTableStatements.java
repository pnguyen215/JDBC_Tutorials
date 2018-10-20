package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStatements {

	public CreateTableStatements() {
	}

	public static void createTable() {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "create table student(id int primary key, name nvarchar(45))";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		createTable();
		System.out.println("Created table in given database...");
	}

}
