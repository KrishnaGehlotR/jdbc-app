package com.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePlatform {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			System.out.println("forName : "+forName);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with DB Server");
			System.out.println("con : "+con);
			
			stmt = con.createStatement();
			System.out.println("Create Statement or Platform");
			System.out.println("stmt : "+stmt);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
					System.out.println("Connection Closed : "+con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
					System.out.println("Statement Closed : ");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
