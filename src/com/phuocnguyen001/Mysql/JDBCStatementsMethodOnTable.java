package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementsMethodOnTable {

	public JDBCStatementsMethodOnTable() {
	}

	public static void insertRecord() {

		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "insert into student values(1,'Nguyen Van A')";
			statement.executeUpdate(sql);
			sql = "insert into student values(2,'Nguyen Van B')";
			statement.executeUpdate(sql);
			sql = "insert into student values(3,'Nguyen Van C')";
			statement.executeUpdate(sql);
			sql = "insert into student values(4,'Nguyen Van D')";
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			System.out.println("Inserted records into the table...");
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static int deleteRecord(int id) {
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "delete from student where id = " + id;
			int result = statement.executeUpdate(sql);
			System.out.println("This Object is deleted! ");
			connection.close();
			statement.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean updateRecord(int id, String newName) {
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "update student set name  = ' " + newName + " ' where id = " + id;
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			// System.out.println("This Object has ID = " + id + " has changed!");
			connection.close();
			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// insertRecord();
		// deleteRecord(1);
		System.out.println(updateRecord(4, "PhuocNguyen"));

	}

}
