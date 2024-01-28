package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {
<<<<<<< HEAD
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/flipfit_schema";
=======
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/FlipfitSchema";
>>>>>>> 0e9a80c (check)

	static final String USER = "root";

	static final String PASS = "12345678";
	
	/**
	 * Execute the given Update/Delete/Insert Query
	 * @param statement
	 * @return
	 */
	
	public static int executeDMLQuery(PreparedStatement statement) {
		if(statement != null) {
			try {
				//System.out.println("Executing Query " + statement);
				return statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * Execute the given fetch query
	 * @param statement
	 * @return result from the execution
	 */
	
	public static ResultSet executeQuery(PreparedStatement statement) {
		ResultSet rs=null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * Create connection 
	 * @return Connection object
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