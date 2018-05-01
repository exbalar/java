package com.java.basic.concurrency;

import java.util.concurrent.CountDownLatch;
class Decrementer implements Runnable{

	CountDownLatch latch;
	public Decrementer(CountDownLatch l) {
		latch = l;
	}
	@Override
	public void run() {
		
		try {
			latch.countDown();
			Thread.sleep(1000);
			latch.countDown();
			Thread.sleep(1000);
			latch.countDown();
			System.out.println("Done at incrementer");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
class Waiter implements Runnable{
	CountDownLatch latch;
	public Waiter(CountDownLatch l) {
		latch = l;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting...");
			latch.await();
			System.out.println("Waiting...over!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class CountDownLatchTest {

	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new Waiter(latch)).start();
		new Thread(new Decrementer(latch)).start();

	}

}
