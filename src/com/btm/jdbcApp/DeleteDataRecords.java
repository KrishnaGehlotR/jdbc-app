package com.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataRecords {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "delete from seja5.students where regno=420;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded and registered");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with DB server");
			
			stmt = con.createStatement();
			System.out.println("Platoform created");
			
			stmt.executeUpdate(qry);
			System.out.println("Data Deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}