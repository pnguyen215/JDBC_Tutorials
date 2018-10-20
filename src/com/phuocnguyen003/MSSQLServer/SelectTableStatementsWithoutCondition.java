package com.phuocnguyen003.MSSQLServer;

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
			String sql = "SELECT * FROM Student";
			ResultSet resultSet = statement.executeQuery(sql);
			List<Student> listStudent = new ArrayList<Student>();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double gpa = resultSet.getDouble(3);
				String major = resultSet.getString(4);
				Student student = new Student(id, name, gpa, major);
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
