package com.java.basic;
enum Enums{
	INSTANCE;
	public  void doSomething(){
		System.out.println("HIII");
    }
}
public class EnumSingleton {
	public static void main(String[] args) {
		System.out.println(Enums.INSTANCE);
		Enums.INSTANCE.doSomething();
	}
}


