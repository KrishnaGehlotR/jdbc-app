package com.btm.jdbcApp;

import java.sql.*;

public class ResultSetInerfaceAbsoluteMethod {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String qry = "select * from seja5.students";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			boolean val = rs.absolute(4);
			if(val) {
				int id = rs.getInt("regno");
				String name = rs.getString(2);
				double perc = rs.getDouble(3);
				System.out.println("Rgno : "+id);
				System.out.println("Name : "+name);
				System.out.println("Perc : "+perc);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
