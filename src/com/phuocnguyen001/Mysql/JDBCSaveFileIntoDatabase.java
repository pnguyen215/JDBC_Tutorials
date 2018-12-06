package com.phuocnguyen001.Mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCSaveFileIntoDatabase {

	public JDBCSaveFileIntoDatabase() {
	}

	public static void main(String[] args) {

		/*
		 * open gate of connection
		 */
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = null;
		PreparedStatement preparedStatement = null;
		/*
		 * create object file
		 */
		File file = new File("Note.txt");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);/* create thread to write content to file */
			sql = "insert into file(name,file) values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Note.txt");
			preparedStatement.setBinaryStream(2, fileInputStream);
			/* execute this statement */
			preparedStatement.executeUpdate();
			System.out.println("Save is completely!"); /* check processing save file into database */
			/*
			 * close all connection
			 */
			connection.close();
			preparedStatement.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
