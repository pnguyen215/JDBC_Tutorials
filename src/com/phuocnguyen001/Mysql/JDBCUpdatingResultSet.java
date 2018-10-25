package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUpdatingResultSet {

	public JDBCUpdatingResultSet() {
	}

	public static void printOut(ResultSet statement) throws SQLException {
		System.out.println("List result set...");
		/*
		 * Ensure we start with first row
		 */
		statement.beforeFirst();
		/* Declaring array to save object */
		List<Student> list = new ArrayList<Student>();
		while (statement.next()) {
			/* Retrieve by column name */
			int id = statement.getInt(1);
			String name = statement.getString(2);
			Student student = new Student(name, id);
			list.add(student);
		}
		/* Displaying values */
		for (Student student : list) {
			System.out.println(student.toString());
		}
		System.out.println();
	}

	public static ResultSet changeAttributeById(int id, ResultSet resultSet) throws SQLException {
		System.out.println("Changing id attributes...");
		/*
		 * Loop through result set and add 5 in id
		 */
		resultSet.beforeFirst();/* moving cursor position */
		while (resultSet.next()) {
			int newId = resultSet.getInt(1) + id; /* increase each id to 5 units */
			resultSet.updateDouble("id", newId);
			resultSet.updateRow();
		}

		return resultSet;

	}

	public static ResultSet changeAttributeByName(String name, ResultSet resultSet) throws SQLException {
		System.out.println("Changing name attributes...");
		/* moving cursor position */
		resultSet.beforeFirst();
		while (resultSet.next()) {
			resultSet.updateString("name", name); /* updating all of rows name */
			resultSet.updateRow();
		}
		return resultSet;
	}

	public static ResultSet insertNewRecord(int id, String name, ResultSet resultSet) throws SQLException {

		System.out.println("Inserting a new record...");
		resultSet.moveToInsertRow();
		/*
		 * insert values
		 */
		/*
		 * In table on database, we have two attribute: id, name.
		 */
		resultSet.updateInt("id", id);
		resultSet.updateString("name", name);
		/*
		 * commit row
		 */
		resultSet.insertRow();
		return resultSet;

	}

	public static ResultSet deleteAnyRecord(int position, ResultSet resultSet) throws SQLException {
		System.out.println("Deleting record...");
		/* Set position you to delete it */
		resultSet.absolute(position);
		/* deleting this row */
		resultSet.deleteRow();
		return resultSet;

	}

	public static void main(String[] args) {

		Connection connection = JDBCConnection.getJDBCConnection();
		Statement statement = null;
		String sql = null;
		try {
			/*
			 * Execute a query to create statement with required arguments for RS example.
			 */
			System.out.println("Creating statement...");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/*
			 * Block transaction
			 */
			connection.setAutoCommit(false);
			/*
			 * Execute a query
			 */
			sql = "select * from student";
			ResultSet resultSet = statement.executeQuery(sql);
			/* printOut */
			printOut(resultSet);
			/* updating attribute id */
			changeAttributeById(0, resultSet);
			/* printOut */
			printOut(resultSet);
			/* updating attribute name */
			changeAttributeByName("David", resultSet);
			/* printOut */
			printOut(resultSet);
			/*
			 * insert new record
			 */
			insertNewRecord(6, "David", resultSet);
			/* printOut */
			printOut(resultSet);
			/*
			 * Deleting any row
			 */
			deleteAnyRecord(5, resultSet);
			/*
			 * printOut
			 */
			printOut(resultSet);
			/*
			 * commit
			 */
			connection.commit();

			/*
			 * close connection
			 */
			connection.close();
			statement.close();
			resultSet.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
