package com.btm.jdbcApp;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class RegisterDriver {

	public static void main(String[] args) {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver Loaded and Registered");
			System.out.println(driver.getClass());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
