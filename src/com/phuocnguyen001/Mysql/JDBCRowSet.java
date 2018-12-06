package com.phuocnguyen001.Mysql;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSet {

	public JDBCRowSet() {
	}

	public static void main(String[] args) {

		final String url = "jdbc:mysql://localhost:3306/managestudent";
		final String user = "root";
		final String password = "";
		/*
		 * create SQL query
		 */
		final String sql = "select * from student";

		try {
			/*
			 * register for driver
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/*
			 * create new RowSet
			 */
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			/*
			 * login into database by using RowSet through set a lot of procedures
			 */

			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			/*
			 * execute SQL query
			 */
			jdbcRowSet.setCommand(sql);
			jdbcRowSet.execute();

			/*
			 * show print out data on database
			 */
			while (jdbcRowSet.next()) {
				System.out.println("id: " + jdbcRowSet.getInt(1) + " name: " + jdbcRowSet.getString(2));
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
		}

	}

}
