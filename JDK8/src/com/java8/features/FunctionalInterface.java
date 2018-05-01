package com.java8.features;

interface FunctionalInterface3 {
	void  displayd();
	 default void  display() {
		
	}
}
interface FunctionalInterface2 {
	public static  String a = "10";
	void  displayd();
	default void  display() {
	}
}
public class FunctionalInterface implements FunctionalInterface2,FunctionalInterface3{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		FunctionalInterface2.super.display();
	}

	@Override
	public void displayd() {
		// TODO Auto-generated method stub
		
	}

}
