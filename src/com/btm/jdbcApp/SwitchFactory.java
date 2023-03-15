package com.btm.jdbcApp;

import java.util.Scanner;

interface Iswitch {
	void sON();
	void sOFF();
}

class TubeLightImpl implements Iswitch {

	@Override
	public void sON() {
		System.out.println("Tubelight is turned ON");
	}

	@Override
	public void sOFF() {
		System.out.println("Tubelight is turned OFF");
	}
}

class LEDImpl implements Iswitch {

	@Override
	public void sON() {
		System.out.println("Led is turned ON");
	}

	@Override
	public void sOFF() {
		System.out.println("LED is turned OFF");
	}
}

class LightFactory {
	
	public static Iswitch getLight(String type) {
		if(type.equalsIgnoreCase("Tubelight")) {
			return new TubeLightImpl();
		}
		else if (type.equalsIgnoreCase("Led")) {
			return new LEDImpl();
		}
		else {
			System.out.println("No switch found");
			return null;
		}
	}
}

public class SwitchFactory {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter type of light");
		String type = sc.nextLine();
		sc.close();
		
		Iswitch sw = LightFactory.getLight(type);
		if(sw!= null) {
			sw.sON();
			sw.sOFF();
		}
	}
}