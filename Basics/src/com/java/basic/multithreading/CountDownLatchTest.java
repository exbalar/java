package com.java.basic.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	private CountDownLatch latch;
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}
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
		latch.countDown();
		
	}
	
}
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService exe = Executors.newScheduledThreadPool(2);
		
		for(int i =0 ; i < 3; i++) {
			exe.submit(new Processor(latch));
		}
		exe.shutdown();
		latch.await();
		System.out.println("Over!!!!");
		
		
	}

}
