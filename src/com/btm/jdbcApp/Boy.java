package com.btm.jdbcApp;

public class Boy {
  
	void drink(){
		System.out.println("Krishna is drinking coffee");
	}
	
	public static void main(String[] args) {
		Boy boy = new Boy();
		boy.drink();
	}
}