package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableStatements {

	public DropTableStatements() {
	}

	public static void dropTable() {
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			Statement statement = connection.createStatement();
			String sql = "drop table student";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		dropTable();
		System.out.println("Table  deleted in given database...");
	}

}
