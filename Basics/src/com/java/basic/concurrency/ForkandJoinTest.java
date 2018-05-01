package com.java.basic.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask{
	int i =0;
	public MyTask(int i) {
		this.i =i;
	}
	@Override
	protected Object compute() {
		if(i>4){
			List<MyTask> tasklist = new ArrayList<>();
			tasklist.add(new MyTask(i/2));
			tasklist.add(new MyTask(i/2));
			for(MyTask m : tasklist){
				 m.fork();
			}
			int result = 0;
			for(MyTask m : tasklist){
				System.out.println("Hi...");
				result += (int) m.join();
				System.out.println(result );
			}
			return result;
		}else{
			return i*2;
		}
	}
	
}
public class ForkandJoinTest {

	public static void main(String[] args) {
		ForkJoinPool jp = new ForkJoinPool(10);
		System.out.println(jp.invoke(new MyTask(6)));
	}

}
