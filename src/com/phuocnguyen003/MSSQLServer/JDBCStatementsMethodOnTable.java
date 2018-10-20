package com.phuocnguyen003.MSSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCStatementsMethodOnTable {

	public JDBCStatementsMethodOnTable() {
	}

	public static void insertRecord(int id, String name, double gpa, String major) {

		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "insert into student(id, name,gpa,major) values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, gpa);
			preparedStatement.setString(4, major);
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int deleteRecord(int id) {

		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			String sql = "delete from Student where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;

	}

	public static boolean updateRecord(int id, String newName, double gpa, String major) {

		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "update Student set name = ? , gpa = ?, major = ? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setDouble(2, gpa);
			preparedStatement.setString(3, major);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public static void main(String[] args) {
		// insertRecord(9, "David", 9.8, "History");
		// deleteRecord(9);
		// updateRecord(1, "PhuocNguyen", 10, "CNTT");
	}
}
