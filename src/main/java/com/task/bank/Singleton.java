package com.task.bank;

public class Singleton {

		public static Singleton instance;
		
		Singleton() {
			
			 		
		} 
		

		public static Singleton getInstance() {
		    if (instance == null) {
		    	synchronized (Singleton.class) {
		    	  if (instance == null) {
	                    instance = new Singleton();
	                    System.out.println("Object Created");
	                }
		    	}
		       
		    }
		    return instance;
		}

		public static void display() {
			System.out.println("Singleton Executed");
		}
		
		
		
	
}
