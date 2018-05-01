package com.java.basic.concurrency;

class Sender implements Runnable{
	Object obj = null;
	public Sender(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("before run>>> Sender");
			SignalingTest.a = 235;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			obj.notify();
			System.out.println("after run>>> Sender");
		}
	}
	
	
}
class Receiver implements Runnable{
	Object obj = null;
	public Receiver(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized (obj) {
			try {
				System.out.println("before run>>> Receiver");
				obj.wait();
				System.out.println("after run>>> Receiver"+ SignalingTest.a);
				SignalingTest.c = SignalingTest.a;
				System.out.println(SignalingTest.c);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}

public class SignalingTest {

	static int a = 0;
	static int c = 0;
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		new Thread(new Receiver(obj)).start();
		new Thread(new Sender(obj)).start();
		//Thread.currentThread().join();
		//System.out.println(a);
		
	}

}
