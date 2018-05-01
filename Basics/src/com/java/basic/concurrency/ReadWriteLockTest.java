package com.java.basic.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyThread extends Thread{

	ReadWriteLock rl;
	
	public MyThread(ReadWriteLock el) {
		rl = el;
	}
	@Override
	public void run() {
		System.out.println("Entering to read block...");
		rl.readLock().lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Coming out of read block..");
		rl.readLock().unlock();
		System.out.println("Entering to write block..");
		rl.writeLock().lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		rl.writeLock().unlock();
		
	}
}
public class ReadWriteLockTest {

	public static void main(String[] args) {
		ReadWriteLock rl = new ReentrantReadWriteLock();
		new MyThread(rl).start();
		new MyThread(rl).start();
		
	}

}
