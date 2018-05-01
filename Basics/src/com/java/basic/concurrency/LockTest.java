package com.java.basic.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadC extends Thread {
	int i = 0;
	Lock l ;
	public ThreadC(Lock l){
		this.l =l;
	}
	@Override
	public void run() {
		System.out.println("Hi....im waiting for the lock!" + l.tryLock());
		l.lock();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i = i+4;
		if(i == 4){
			l.unlock();
		}
		System.out.println("Released!!!");
	}
}


public class LockTest {

	public static void main(String[] args) {

		ReentrantLock rl = new ReentrantLock();
		new ThreadC(rl).start();
		new ThreadC(rl).start();
		new ThreadC(rl).start();
		new ThreadC(rl).start();
	}

}
