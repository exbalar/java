package com.java.basic.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueTest {

	private static BlockingQueue queue = new ArrayBlockingQueue(2);
	private static void produce() throws InterruptedException {
		while(true) {
			Random ran = new Random();
			queue.put(ran.nextInt(10));
			System.out.println("Item placed::");
		}
		
	}
	
	private static void consume() throws InterruptedException {
		while(true) {
			Thread.sleep(1000);
			System.out.println("Item removed::"+ queue.take());
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread (() -> {
			try {
				produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread (() -> {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		

	}

}
