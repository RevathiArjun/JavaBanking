package com.task.bank;

public class SingletonExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Singleton obj = new Singleton();
		Singleton obj1 = new Singleton();
		obj.getInstance();
		obj1.getInstance();
		obj.display();
		obj1.display();
	}

}

