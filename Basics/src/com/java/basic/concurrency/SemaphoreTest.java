package com.java.basic.concurrency;

import java.util.concurrent.Semaphore;


public class SemaphoreTest {
	static Semaphore s = new Semaphore(1);
	static class SemaphoreC extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			System.out.println("before>>"+s.availablePermits());
			try {
				s.acquire();
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(2000);
				int a = 10 - 5;
				s.release();
				System.out.println("limit>>"+s.availablePermits());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
		}
	}
	public static void main(String[] args) {
		new SemaphoreTest.SemaphoreC().start();	
		new SemaphoreTest.SemaphoreC().start();
	}

}
