package com.java.basic.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable {

	@Override
	public void run() {
		System.out.println("Starting.." + Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed.." + Thread.currentThread().getName());
		
	}
	
}
public class ExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		//ExecutorService exe = Executors.newFixedThreadPool(2);
		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i=0; i < 10 ; i++) {
			exe.submit(new Process());
		}
		exe.shutdown();
		exe.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("Over!");
		
	}

}
