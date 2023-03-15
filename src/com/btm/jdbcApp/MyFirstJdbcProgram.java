package com.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJdbcProgram {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			/* 1.
			 * Load the driver
			 * Driver class: com.mysql.jdbc.Driver
			 */
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			/* 2.
			 * Get DB connection via Driver
			 */
			String dbUrl = "jdbc:mysql://localhost:3306/j2ee?autoReconnect=true&useSSL=false&user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			/* 3.
			 * Issue SQL queries via connection
			 */
			String query = "select * from students_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			/* 4.
			 * Process the Results returned by SQL queries
			 */
			while(rs.next()) {
				int regNumber = rs.getInt("regno");
				String firstName = rs.getString("firstname");
				String middleName = rs.getString("middlename");
				String lastName = rs.getString("lastname");
				
				System.out.println("Reg no : "+regNumber);
				System.out.println("First name : "+firstName);
				System.out.println("Middle name : "+middleName);
				System.out.println("Last name : "+lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			/* 5.
			 * Close all jdbc objects
			 * 
			 */
			try {
				if(con!=null) {
					con.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}// End of outer try-catch block
	}// End of main
}// End of class