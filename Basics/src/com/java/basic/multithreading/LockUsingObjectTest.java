package com.java.basic.multithreading;

import java.util.ArrayList;
import java.util.List;

class MyProcess {
	Object obj = new Object();
	List<Integer> lis = new ArrayList<>();
	int limit = 10;
	public void produce() throws InterruptedException {
		int value = 0;
		while(true) {
			synchronized(obj) {
				System.out.println("Entering in producer..." + lis.size());
				while(lis.size() == limit) {
					System.out.println("Waiting....in producer..");
					obj.wait();
				}
				lis.add(value++);
				obj.notify();
			}
		}
		
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(obj) {
				System.out.println("Entering in consumer..." + lis.size());
				while(lis.size() == 0) {
					System.out.println("waiting in Consumer..");
					obj.wait();
				}
				lis.remove(0);
				obj.notify();
				Thread.sleep(2000);
			}
		}
		
	}
	
}

public class LockUsingObjectTest {

	public static void main(String[] args) {

		MyProcess m = new MyProcess();
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
