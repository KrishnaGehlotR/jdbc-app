package com.btm.jdbcApp;

public class ClassForName {

	public static void main(String[] args) {
		try {
			Class.forName("com.btm.jdbcApp.LoadClass");
			Class.forName("com.btm.jdbcApp.LoadInterface");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class LoadClass { 
	
	static {
		System.out.println("This is static block");
	}
}

interface LoadInterface {
	
}
