package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransaction {

	public JDBCTransaction() {
	}

	public static void main(String[] args) {

		Connection connection = JDBCConnection.getJDBCConnection();

		try {
			PreparedStatement preparedStatement = null;
			connection.setAutoCommit(false); // transaction top
			String sql1 = "insert into student(id,name) values(?,?)";
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "PhuocNguyen");
			preparedStatement.executeUpdate();
			String sql2 = "delete from student where id = ?";
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, 3);
			preparedStatement.executeUpdate();
			connection.commit(); // transaction bottom
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
