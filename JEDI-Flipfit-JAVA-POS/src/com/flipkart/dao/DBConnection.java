package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a database connection utility.
 */
public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/flipfit_schema";

	static final String USER = "root";
	static final String PASS = "password";

	/**
	 * Execute the given Update/Delete/Insert Query.
	 *
	 * @param statement the prepared statement containing the query
	 * @return the number of rows affected by the query
	 */
	public static int executeDMLQuery(PreparedStatement statement) {
		if (statement != null) {
			try {
				return statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * Execute the given fetch query.
	 *
	 * @param statement the prepared statement containing the query
	 * @return the result set obtained from the query execution
	 */
	public static ResultSet executeQuery(PreparedStatement statement) {
		ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Create a database connection.
	 *
	 * @return a Connection object representing the database connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Database could not be connected");
		}
		return conn;
	}
}