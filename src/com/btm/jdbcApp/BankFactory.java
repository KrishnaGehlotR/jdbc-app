package com.btm.jdbcApp;

import java.util.Scanner;

interface ICard {
	void swipe();
}

class SbiImpl implements ICard {

	@Override
	public void swipe() {
		System.out.println("Card Swiped");
	}
}

class HdfcImpl implements ICard {

	@Override
	public void swipe() {
		System.out.println("Card Swiped");
	}
}

class CardFactory {
	
	public static ICard getMoney(String type) {
		if(type.equalsIgnoreCase("SBI")) {
			return new SbiImpl();
		}
		else if (type.equalsIgnoreCase("HDFC")) {
			return new HdfcImpl();
		}
		else {
			System.out.println("Insert Properly");
			return null;
		}
	}
}

public class BankFactory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Insert Card");
		String type = sc.next();
		sc.close();
		
		ICard ic = CardFactory.getMoney(type);
		ic.swipe();
	}
}