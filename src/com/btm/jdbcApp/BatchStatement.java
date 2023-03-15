package com.btm.jdbcApp;

import java.sql.*;

public class BatchStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String InsQry = "insert into seja4.employee values(1,'mynu', 20000)";
		String updQry = "Update seja5.students set perc=60.55 where id = 1";
		String delQry = "delete from seja5.students where perc=78.45";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt = con.createStatement();
			stmt.addBatch(InsQry);
			stmt.addBatch(updQry);
			stmt.addBatch(delQry);
			int[] arr = stmt.executeBatch();
			for (int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println("Batch Updated");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
