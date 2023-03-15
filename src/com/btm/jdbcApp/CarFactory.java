package com.btm.jdbcApp;

public class CarFactory {
	
	public static void main(String[] args) {
		CarFactory.getCar("benz");
		CarFactory.getCar("honda");
		CarFactory.getCar("Bmw");
	}

	public static CarFactory getCar(String type) {
		if(type.equalsIgnoreCase("Benz")) {
			return new Benz();
		}
		else if(type.equalsIgnoreCase("Honda")) {
			return new Honda();
		}
		else {
			System.out.println("Requested car does not found");
			return null;
		}
	}
}

class Benz extends CarFactory {
	Benz() {
		System.out.println("Benz car");
	}
}

class Honda extends CarFactory {
	Honda(){
		System.out.println("Honda car");
	}
}
