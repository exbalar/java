package com.java.basic.multithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyProcessClass {
	Lock lock = new ReentrantLock();
	Condition con = lock.newCondition();
	int count = 0;
	public void increment() {
		count ++;
	}
	public void firstThread() throws InterruptedException {
		lock.lock();
		con.await();
		for(int i =0; i < 10000 ; i++) {
			increment();
		}
		lock.unlock();
	}
	
	public void secondThread() throws InterruptedException {
		Thread.sleep(2000);
		lock.lock();
		new Scanner(System.in).nextLine();
		con.signal();
		for(int i =0; i < 10000 ; i++) {
			increment();
		}
		lock.unlock();

	}
	
	public void print() {
		System.out.println(count);
	}
	
}

public class ReEntrantLockTest {

	public static void main(String[] args) throws InterruptedException {
		MyProcessClass mp = new MyProcessClass();
		Thread t1 = new Thread(() -> {
			try {
				mp.firstThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		Thread t2 = new Thread(() -> {
			try {
				mp.secondThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		mp.print();
		
		
	}

}
