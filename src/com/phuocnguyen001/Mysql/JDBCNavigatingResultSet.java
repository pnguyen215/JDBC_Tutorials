package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCNavigatingResultSet {

	public JDBCNavigatingResultSet() {
	}

	public static void main(String[] args) {

		Connection connection = JDBCConnection.getJDBCConnection();
		Statement statement = null;

		try {
			/*
			 * Execute a query to create statement with required arguments for RS example.
			 */
			System.out.println("Creating statement...");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from student";
			ResultSet resultSet = statement.executeQuery(sql);
			/*
			 * Move cursor to the last row.
			 */
			System.out.println("Moving cursor ot the last row...");
			resultSet.last();
			/*
			 * Extract data from result set
			 */
			System.out.println("Displaying records... ");
			/*
			 * Retrieve by column name
			 */
			int id = resultSet.getInt(1); /* 1: id */
			String name = resultSet.getString(2); /* 2: name */
			/*
			 * Displaying values
			 */
			System.out.println("ID: " + id);
			System.out.println("Name: " + name);
			/*
			 * Move cursor to the first row.
			 */
			System.out.println("Moving cursor ot the first row...");
			resultSet.first();
			/*
			 * Extract data from result set
			 */
			System.out.println("Displaying records... ");
			/*
			 * Retrieve by column name
			 */
			int id2nd = resultSet.getInt("id");
			String name2nd = resultSet.getString("name");
			/*
			 * Displaying values
			 */
			System.out.println("ID: " + id2nd);
			System.out.println("Name: " + name2nd);
			/*
			 * close all connection
			 */
			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
