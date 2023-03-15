package com.btm.jdbcApp;

import java.sql.*;

public class PstmtGetXXX {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from seja5.students";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);
			
//			Code to fetch single records
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString(2);
				String perc = rs.getString(3);
				System.out.println(id+" "+name+" "+perc);
			}
			System.out.println("=========================");
//			Code to fetch multiple records
			while(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString(2);
				String perc = rs.getString(3);
				System.out.println(id+" "+name+" "+perc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
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