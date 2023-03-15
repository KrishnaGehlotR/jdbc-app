package com.btm.jdbcApp;

import java.sql.*;

public class BatchPreparedStatement {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		String insQry = "insert into seja4.employee values(1, 'Raj', 66.45)";
		String delQry = "delete from seja5.students where perc=69.99";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(insQry);
			pstmt.addBatch();
			int arr[] = pstmt.executeBatch();
			for (int i : arr) {
				System.out.println(i);
			}
			
			pstmt1 = con.prepareStatement(delQry);
			pstmt1.addBatch();
			int arr1[] = pstmt1.executeBatch();
			for (int j : arr1) {
				System.out.println(j);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if(pstmt1!=null) {
					pstmt1.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}