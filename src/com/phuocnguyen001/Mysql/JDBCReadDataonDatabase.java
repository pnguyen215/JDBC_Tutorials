package com.phuocnguyen001.Mysql;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCReadDataonDatabase {

	public JDBCReadDataonDatabase() {
	}

	public static void main(String[] args) {

		/*
		 * open gate of connection
		 */
		Connection connection = JDBCConnection.getJDBCConnection();
		/*
		 * declared variables
		 */
		String sql = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		FileOutputStream fileOutputStream;

		sql = "select * from file";
		try {
			preparedStatement = connection.prepareStatement(sql); /* connect to database */
			resultSet = preparedStatement.executeQuery(); /* execute this statement */
			/*
			 * processing read file from database
			 */
			while (resultSet.next()) {
				/*
				 * set attributes for fields on database
				 */
				String name = resultSet.getString("name");
				Blob file = resultSet.getBlob("file");
				/*
				 * create array to get data from file
				 */
				byte[] contentOnDatabase = file.getBytes(1, (int) file.length());
				/*
				 * open thread to read contents on database
				 */
				fileOutputStream = new FileOutputStream(name);
				fileOutputStream.write(contentOnDatabase);

				/*
				 * close all connection
				 */
				fileOutputStream.close();

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * 
		 */
		System.out.println("Read data on database is completely!");
	}

}
