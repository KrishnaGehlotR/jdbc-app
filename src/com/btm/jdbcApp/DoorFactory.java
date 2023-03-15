package com.btm.jdbcApp;

import java.util.Scanner;

interface IDoor {
	void openDoor();
	void closeDoor();
}

class FrontDoor implements IDoor {

	@Override
	public void openDoor() {
		System.out.println("Open Front Door");
	}

	@Override
	public void closeDoor() {
		System.out.println("Close Front Door");
	}
}

class BackDoor implements IDoor {

	@Override
	public void openDoor() {
		System.out.println("Open Back Door");
	}

	@Override
	public void closeDoor() {
		System.out.println("Close Back Door");
	}
}

class DoorFactoryImpl {
	
	public static IDoor getDoor(String type) {
		if(type.equalsIgnoreCase("frontDoor")) {
			return new FrontDoor();
		}
		else if(type.equalsIgnoreCase("backDoor")) {
			return new BackDoor();
		}
		else {
			System.out.println("No Door Found");
			return null;
		}
	}
}

public class DoorFactory {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the type of door");
		
		String type = sc.next();
		sc.close();
		
		IDoor id = DoorFactoryImpl.getDoor(type);
		if(id!=null) {
			id.openDoor();
			id.closeDoor();
		}
	}
}