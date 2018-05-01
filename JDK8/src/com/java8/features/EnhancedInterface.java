package com.java8.features;

@FunctionalInterface
interface AdvancedInterface {
	 default void test() {
		 System.out.println("At .....");
	 }
	 static void check() {
		 System.out.println("At .....check...");
	 }
	 void get();
}

@FunctionalInterface
interface AdvancedInterface2 {
	 default void test() {
		 System.out.println("At .....");
	 }
	 static void check() {
		 System.out.println("At .....check...");
	 }
	 void get();
}

class testInterface implements AdvancedInterface,AdvancedInterface2{

	@Override
	public void get() {

		System.out.println("At testInterface..");
	}
	
	public void test() {
		System.out.println("At test...");
	}
}
public class EnhancedInterface {

	public static void main(String[] args) {

		AdvancedInterface ai = new testInterface();
		ai.get();
		ai.test();
		AdvancedInterface.check();
	}

}
