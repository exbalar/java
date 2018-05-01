package com.java.basic.concurrency;

class MyThreadLocal implements Runnable {

	public static ThreadLocal<String> tl = new ThreadLocal<>();
	
	@Override
	public void run() {
		System.out.println("before>>"+tl.get());
		tl.set(""+Math.random());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after>>"+tl.get());
	}
	
}
public class ThreadLocalTest {

	public static void main(String[] args) {
		MyThreadLocal.tl.set("bala");
		new Thread(new MyThreadLocal()).start();
		new Thread(new MyThreadLocal()).start();
		new Thread(new MyThreadLocal()).start();

	}

}
