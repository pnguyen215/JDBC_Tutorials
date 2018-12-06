package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCDatabaseMetaData {

	public JDBCDatabaseMetaData() {
	}

	public static void main(String[] args) {

		/*
		 * open connection
		 */
		Connection connection = JDBCConnection.getJDBCConnection();

		try {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			/*
			 * result
			 */
			System.out.println(databaseMetaData.getDatabaseProductName());/* get name server database */
			System.out.println(databaseMetaData.getDatabaseProductVersion()); /* get version server */
			System.out.println(databaseMetaData.getDriverName()); /* get name driver */
			System.out.println(databaseMetaData.getUserName());
			System.out.println(databaseMetaData.getURL());
			System.out.println(databaseMetaData.getDriverMajorVersion());
			System.out.println(databaseMetaData.getSchemas());
			System.out.println(databaseMetaData.getCatalogTerm());
			System.out.println(databaseMetaData.getTypeInfo());
			/*
			 * close connection
			 */
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
