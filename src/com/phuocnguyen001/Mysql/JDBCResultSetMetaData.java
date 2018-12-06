package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCResultSetMetaData {

	public JDBCResultSetMetaData() {
	}

	public static void main(String[] args) {

		/*
		 * open connection
		 */
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "select * from student";
		try {
			/*
			 * execute SQL string
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			/*
			 * declared ResultSetMetaData to start method on this class
			 */
			ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
			/*
			 * result
			 */
			System.out.println(resultSetMetaData.getColumnCount()); /* get sum of columns */
			System.out.println(resultSetMetaData.getColumnDisplaySize(1)); /* size on first column */
			System.out.println(resultSetMetaData.getColumnDisplaySize(2));/* size on second column */
			System.out.println(resultSetMetaData.getColumnLabel(1)); /* label on first column */
			System.out.println(resultSetMetaData.getColumnLabel(2)); /* label on second column */
			System.out.println(resultSetMetaData.isAutoIncrement(1)); /* id column is not increment */
			System.out.println(resultSetMetaData.isSearchable(1));
			System.out.println(resultSetMetaData.isWritable(2));
			System.out.println(resultSetMetaData.getCatalogName(1)); /* get name database */
			System.out.println(resultSetMetaData.getTableName(1)); /* get name table on database */
			System.out.println(resultSetMetaData.isSigned(1));
			/*
			 * close all connection
			 */
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
