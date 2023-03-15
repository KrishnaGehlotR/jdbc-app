package com.btm.jdbcApp;

import java.sql.*;

public class InsertMultipleRecords {
	

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into seja5.students values(4, 'Vijay', 67.88)";
		String qry2 = "insert into seja5.students values(5, 'Ajay', 68.88)";
		String qry3 = "insert into seja5.students values(6, 'Sujay', 69.89)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection Established with Database Server");
			
			stmt = con.createStatement();
			System.out.println("Platfrom Created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			
			System.out.println("Data Inserted!!!");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
