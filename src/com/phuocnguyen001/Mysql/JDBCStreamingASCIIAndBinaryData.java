package com.phuocnguyen001.Mysql;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStreamingASCIIAndBinaryData {

	public JDBCStreamingASCIIAndBinaryData() {
	}

	public static void createXMLTable(Statement statement) throws SQLException {
		System.out.println("Creating XML_Data table...");
		/*
		 * Create SQL Statement
		 */
		String string = "CREATE TABLE XML_Data " + "(id INTEGER, name LONG)";
		/*
		 * Drop table first if table is exist
		 */
		try {
			statement.executeUpdate("drop table XML_Data");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * Build table
		 */
		statement.executeUpdate(string);
	}

	public static void main(String[] args) {

		Connection connection = JDBCConnection.getJDBCConnection();
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			/*
			 * Create a Statement object and build table
			 */
			statement = connection.createStatement();
			createXMLTable(statement);
			/*
			 * Open FileInputStream
			 */
			File file = new File("XML_Data.xml");
			long fileLength = file.length();
			FileInputStream fileInputStream = new FileInputStream(file);
			/*
			 * Create PreparedStatement and stream data
			 */
			String sql = "insert into XML_Data(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 100);
			preparedStatement.setAsciiStream(2, fileInputStream, (int) fileLength);
			preparedStatement.execute();
			/*
			 * close connection to file
			 */
			fileInputStream.close();
			/*
			 * Do a query to get the row
			 */
			sql = "select name from XML_Data where  id = 100";
			resultSet = statement.executeQuery(sql);
			/*
			 * Get the first row
			 */
			if (resultSet.next()) {
				/*
				 * Retrieve data from input stream
				 */
				InputStream inputStream = resultSet.getAsciiStream(1);
				int words;
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				while ((words = inputStream.read()) != -1) {
					byteArrayOutputStream.write(words);
					/*
					 * print out
					 */
					System.out.println(byteArrayOutputStream.toString());
				}
			}
			/*
			 * Clean-up environment
			 */
			resultSet.close();
			statement.close();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getCause());
		}

	}

}
