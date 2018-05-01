package com.java.basic.multithreading;

import java.util.Scanner;

class MyThread {
	public void produce() throws InterruptedException {
		synchronized(this) {
			System.out.println("Entered prooducer..and waiting..");
			wait();
			System.out.println("Resumed...");
		}
		
	}
	
	public void consume() throws InterruptedException {
		Scanner s = new Scanner(System.in);
		synchronized(this) {
			System.out.println("Entered Consumer..and waiting for key press..");
			s.nextLine();
			notify();
			Thread.sleep(5000);
		}
		
	}
	
}

public class WaitAndNotifyTest {

	public static void main(String[] args) {
		MyThread m = new MyThread();
		new Thread (() -> {
			try {
				m.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		
		new Thread (() -> {
			try {
				m.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

}
