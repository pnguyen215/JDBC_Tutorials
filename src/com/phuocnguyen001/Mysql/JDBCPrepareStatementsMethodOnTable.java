package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPrepareStatementsMethodOnTable {

	public JDBCPrepareStatementsMethodOnTable() {
	}

	public static void insertRecords(int id, String name) {

		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			String sql = "insert into Student (id,name) VALUES (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public static int deleteRecords(int id) {

		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "delete from student where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	public static boolean updateRecords(int id, String name) {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "update Student set name = ? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// deleteRecords(1);
		// insertRecords(9, "PhuocNguyen");
		// updateRecords(1, "DavidNguyen");
		for (int i = 0; i < 5; i++) {
			System.out.println(updateRecords(i, "DavidNguyen"));
			// insertRecords(i, "PhuocNguyen" + i);
			// System.out.println(deleteRecords(i));
		}
	}

}
