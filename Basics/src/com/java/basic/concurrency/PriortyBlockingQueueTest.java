package com.java.basic.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Message implements Comparable{

	int priority;
	public Message(int prio) {
		priority = prio;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Message){
			if( ((Message) obj).priority > this.priority){
				return 1;
			}else if (((Message) obj).priority < this.priority){
				return -1;
			}else{
				return 0;
			}
		}
		return 0;
	}
	
}
class ProducerP implements Runnable {
	private BlockingQueue<Message> q = null;
	
	public ProducerP(BlockingQueue<Message> q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
					q.put(new Message(10));
					q.put(new Message(1));
					Thread.sleep(1000);
					q.put(new Message(2));
					Thread.sleep(1000);
					q.put(new Message(21));
					Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

class ConsumerP implements Runnable {
	private BlockingQueue q = null;
	
	public ConsumerP(BlockingQueue<Message> q) {
		this.q = q;
	}

	@Override
	public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(((Message)q.take()).priority);
				System.out.println(((Message)q.take()).priority);
				System.out.println(((Message)q.take()).priority);
				System.out.println(((Message)q.take()).priority);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}

public class PriortyBlockingQueueTest {

	public static void main(String[] args) {
		PriorityBlockingQueue<Message> q = new PriorityBlockingQueue<>();
		new Thread(new ProducerP(q)).start();	
		new Thread(new ConsumerP(q)).start();

	}

}
