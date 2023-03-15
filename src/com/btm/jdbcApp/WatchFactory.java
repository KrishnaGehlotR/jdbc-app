package com.btm.jdbcApp;

public class WatchFactory {

	public static void main(String[] args) {
		WatchFactory.getWatch("fastrack");
		WatchFactory.getWatch("hmt");
		WatchFactory.getWatch("Fossil");
	}
	
	public static WatchFactory getWatch(String type){
		
		if(type.equalsIgnoreCase("fastrack")) 
		{
			return new Fastrack();
		}
		else if(type.equalsIgnoreCase("hmt")) 
		{
			return new Hmt();
		}
		else 
		{
			System.out.println("No watch found");
			return null;
		}
	}
}

class Fastrack extends WatchFactory {
	Fastrack(){
		System.out.println("Fastrack watch");
	}
}

class Hmt extends WatchFactory {
	Hmt(){
		System.out.println("Hmt watch");
	}
}
