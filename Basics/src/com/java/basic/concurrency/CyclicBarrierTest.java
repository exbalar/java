package com.java.basic.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CyclicBarrierClass1 implements Runnable{

	CyclicBarrier cb = null;
	public CyclicBarrierClass1(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting at 1");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	
	}
	
}
class CyclicBarrierClass2 implements Runnable{

	CyclicBarrier cb = null;
	public CyclicBarrierClass2(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting at 2");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
}
class CyclicBarrierClass3 implements Runnable{

	CyclicBarrier cb = null;
	public CyclicBarrierClass3(CyclicBarrier cb) {
		this.cb = cb;
	}
	@Override
	public void run() {
		try {
			System.out.println("Waiting at 3");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
}
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3,new Runnable(){

			@Override
			public void run() {
				System.out.println("All done!");
			}
			
		});
		
		new Thread(new CyclicBarrierClass1(cb)).start();	
		new Thread(new CyclicBarrierClass2(cb)).start();
		
		new Thread(new CyclicBarrierClass3(cb)).start();
		
	}

}
