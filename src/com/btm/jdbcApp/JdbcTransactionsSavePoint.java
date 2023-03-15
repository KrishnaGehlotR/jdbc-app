package com.btm.jdbcApp;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionsSavePoint {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		Savepoint sp = null;
		String stdEdu = "insert into seja5.studentEducational values(?,?,?,?)";
		String stdPer = "insert into seja5.studentPersonal values (?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id???");
		int id = sc.nextInt();
		System.out.println("Enter name???");
		String name = sc.next();
		System.out.println("Enter Dept???");
		String dept = sc.next();
		System.out.println("Enter Percentage???");
		double perc = sc.nextDouble();
		System.out.println("Enter Place???");
		String place = sc.next();
		sc.close();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
//			DISABLE AUTO COMMIT MODE			//
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(stdEdu);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
			pstmt.executeUpdate();
//			1ST DATABASE OPERATION			//
			sp = con.setSavepoint();
			
			pstmt1 = con.prepareStatement(stdPer);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, name);
			pstmt1.setString(3, place);
			pstmt1.executeUpdate();
//			2ND DATABASE OPERATION			//
			
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback(sp);
				con.commit();
				System.out.println("Operations Rolled Back");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
