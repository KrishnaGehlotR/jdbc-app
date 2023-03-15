package com.btm.jdbcApp;

import java.sql.*;

public class InsertDataRecords {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "insert into seja5.students values(420, 'dabi', 55.59);";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with DB Server");
			
			stmt = con.createStatement();
			System.out.println("Platform created");
			
			stmt.executeUpdate(qry);
			System.out.println("Data Inserted!!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}