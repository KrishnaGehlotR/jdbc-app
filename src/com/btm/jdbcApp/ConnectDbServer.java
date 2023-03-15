package com.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDbServer {

	public static void main(String[] args) {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with DB server");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection Closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}