package com.phuocnguyen001.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCBatchProcessing {

	public JDBCBatchProcessing() {

	}

	public static void main(String[] args) {
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql1st = "insert into student(id,name) values(?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql1st);
			/*
			 * Set auto-commit to false
			 */
			connection.setAutoCommit(false);
			/*
			 * Block value 1st
			 */
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "PhuocNguyen");
			preparedStatement.addBatch();
			/*
			 * Block value 2nd
			 */
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "PhuocNguyen");
			preparedStatement.addBatch();
			/*
			 * Block value 3rd
			 */
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "PhuocNguyen");
			preparedStatement.addBatch();
			/*
			 * execute Batch, we have 3 statements
			 */
			int[] result = preparedStatement.executeBatch();
			for (int sysout : result) {
				System.out.println(sysout); /* print out result */
			}
			/*
			 * Explicitly commit statements to apply changes
			 */
			connection.commit();
			/*
			 * close connection
			 */

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
