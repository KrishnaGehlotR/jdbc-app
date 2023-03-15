package com.btm.jdbcApp;

public class LoadDriver {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Registered");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
