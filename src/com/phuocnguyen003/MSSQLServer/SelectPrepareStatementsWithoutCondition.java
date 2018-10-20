package com.phuocnguyen003.MSSQLServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectPrepareStatementsWithoutCondition {

	public SelectPrepareStatementsWithoutCondition() {
	}

	public static void main(String[] args) {

		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "select * from student";
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				double gpa = resultSet.getDouble(3);
				String major = resultSet.getString(4);
				Student student = new Student(id, name, gpa, major);
				list.add(student);
			}
			connection.close();
			preparedStatement.close();
			for (Student student : list) {
				System.out.println(student.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
