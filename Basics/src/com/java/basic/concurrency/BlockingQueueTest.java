package com.java.basic.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	private BlockingQueue q = null;
	
	public Producer(BlockingQueue q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
				//q.add("");
					q.put("Hi");
					Thread.sleep(1000);
					q.put("Hello");
					Thread.sleep(1000);
					q.put("How are you");
					Thread.sleep(1000);
					q.put("How are you");
					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

class Consumer implements Runnable {
	private BlockingQueue q = null;
	
	public Consumer(BlockingQueue q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
				System.out.println(q.take());
				System.out.println(q.take());
				System.out.println(q.take());
				System.out.println(q.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

public class BlockingQueueTest {
	
	public static void main(String[] args) {
		BlockingQueue q = new ArrayBlockingQueue(4);
		new Thread(new Producer(q)).start();
		new Thread(new Consumer(q)).start();
	}

}
