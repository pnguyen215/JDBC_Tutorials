package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectTableStatementsWithoutCondition {

	public SelectTableStatementsWithoutCondition() {
	}

	public static void main(String[] args) {

		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM STUDENT";
			ResultSet resultSet = statement.executeQuery(sql);
			List<Student> listStudent = new ArrayList<Student>();

			while (resultSet.next()) {
				String name = resultSet.getString(2);
				int id = resultSet.getInt(1);
				Student student = new Student(name, id);
				listStudent.add(student);
			}
			// show list student
			for (Student student : listStudent) {
				System.out.println(student.toString());
			}
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
