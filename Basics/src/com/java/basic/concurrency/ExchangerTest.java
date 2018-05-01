package com.java.basic.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Exchanger;

class ProducerE implements Runnable {
	private Exchanger q = null;
	
	public ProducerE(Exchanger q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
				System.out.println(q.exchange("Hi im a producer!! printed at ") + "ProducerE");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

class ConsumerE implements Runnable {
	private Exchanger q = null;
	
	public ConsumerE(Exchanger q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
				System.out.println(q.exchange("Hi im a consumer!! printed at ") + "ConsumerE");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

public class ExchangerTest {
	
	public static void main(String[] args) {
		Exchanger<String> q = new Exchanger<String>();
		new Thread(new ProducerE(q)).start();
		new Thread(new ConsumerE(q)).start();
	}

}
