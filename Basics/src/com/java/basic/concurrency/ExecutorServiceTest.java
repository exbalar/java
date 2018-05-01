package com.java.basic.concurrency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

	static void newFixedPool(){
		System.out.println(Thread.currentThread().getName());
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		});
		es.execute(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		});
		
		es.shutdown();

	}
	
	static void newCachedPool(){
		System.out.println(Thread.currentThread().getName());
		try {
		ExecutorService es = Executors.newCachedThreadPool();
		Future f2 = es.submit(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		});
		Future f = es.submit(new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		});
		System.out.println(f.get() + "___" +f2.get());
		es.shutdown();
		}catch(Exception e){
			
		}

	}
	public static void main(String[] args) {
		//newFixedPool();
		//newCachedPool();
		//newCachedPoolwithCallable();
		invokeAny();
	}

	private static void invokeAny() {


		System.out.println(Thread.currentThread().getName());
		try {
		ExecutorService es = Executors.newCachedThreadPool();
		Set<Callable<Object>> lsis = new HashSet<>();
		lsis.add(new Callable() {
			@Override
			public Object call() {
				System.out.println(Thread.currentThread().getName());
				return Thread.currentThread().getName();
			}
			
		});
		lsis.add(new Callable() {
			@Override
			public Object call() {
				System.out.println(Thread.currentThread().getName());
				return Thread.currentThread().getName();
			}
			
		});
		List<Future<Object>> f2 = es.invokeAll(lsis);
		Object f3 = es.invokeAny(lsis);
		System.out.println( f3+ "___" +f2.get(0).get());
		es.shutdown();
		}catch(Exception e){
			
		}

	
		
	
		
	}

	private static void newCachedPoolwithCallable() {

		System.out.println(Thread.currentThread().getName());
		try {
		ExecutorService es = Executors.newCachedThreadPool();
		Future f2 = es.submit(new Callable() {
	

			@Override
			public Object call() {
				System.out.println(Thread.currentThread().getName());
				return Thread.currentThread().getName();
			}
			
		});
		Future f = es.submit(new Callable(){

			@Override
			public Object call() {
				System.out.println(Thread.currentThread().getName());
				return Thread.currentThread().getName();
			}
			
		});
		System.out.println(f.get() + "___" +f2.get());
		es.shutdown();
		}catch(Exception e){
			
		}

	
		
	}

}
