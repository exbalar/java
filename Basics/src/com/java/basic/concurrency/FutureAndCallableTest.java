package com.java.basic.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ex = Executors.newCachedThreadPool();

		Future<String> future = ex.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				
				
				return "done";
			}
			
		});
		ex.shutdown();
		System.out.println(future.get());
	}

}
