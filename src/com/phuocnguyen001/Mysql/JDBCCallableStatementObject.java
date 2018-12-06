package com.phuocnguyen001.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCallableStatementObject {

	public JDBCCallableStatementObject() {
	}

	public static void main(String[] args) {

		try {
			/*
			 * Open a connection
			 */
			Connection connection = JDBCConnection.getJDBCConnection();
			CallableStatement callableStatement = null;
			/*
			 * Execute a query
			 */
			System.out.println("Creating statement...");
			/*
			 * call function findStudent in database on MySQL
			 */
			String sql = "{call findStudent(?)}";
			callableStatement = connection.prepareCall(sql);
			/*
			 * Bind IN parameter first, then bind OUT parameter
			 */
			String name = "David";
			/*
			 * set values for callableStatement
			 */
			callableStatement.setString(1, name);
			/*
			 * return values after that execute query
			 */
			ResultSet resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("id: " + resultSet.getInt("id") + " name: " + resultSet.getString("name"));
			}
			/*
			 * close connection
			 */
			connection.close();
			callableStatement.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
