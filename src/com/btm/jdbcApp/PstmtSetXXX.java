package com.btm.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PstmtSetXXX {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into seja5.students values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			
//			SET THE VALUES FOR PLACEHOLDER BEFORE EXECUTION			//
			pstmt.setInt(1, 7);
			pstmt.setString(2, "Verma");
			pstmt.setDouble(3, 65.55);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 8);
			pstmt.setString(2, "Sharma");
			pstmt.setDouble(3, 66.66);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 9);
			pstmt.setString(2, "Barma");
			pstmt.setDouble(3, 69.99);
			pstmt.executeUpdate();
			System.out.println("Data Inserted!!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
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
