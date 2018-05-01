package com.java.basic;

public class ShutDownHookTest {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Thread..")));
		//System.exit(0);
		Thread t = new Thread(() -> System.out.println("Thread.."));
		t.start();
		t.start();
	}

}
