package com.phuocnguyen001.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
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
			String sql = "{call getName(?,?)}";
			callableStatement = connection.prepareCall(sql);
			/*
			 * Bind IN parameter first, then bind OUT parameter
			 */
			int id = 7;
			callableStatement.setInt(1, id);
			/*
			 * Because second parameter is OUT so register it
			 */
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			/*
			 * Use execute method to run stored procedure.
			 */
			System.out.println("Executing stored procedure...");
			callableStatement.execute();
			/*
			 * Retrieve employee name with getXXX method
			 */
			String name = callableStatement.getString(2);
			System.out.println("Student Name with ID: " + id + " is " + name);
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
