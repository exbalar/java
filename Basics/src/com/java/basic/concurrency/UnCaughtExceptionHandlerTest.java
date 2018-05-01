package com.java.basic.concurrency;

public class UnCaughtExceptionHandlerTest {

	public static void main(String[] args) {

		Thread t = new Thread(() -> 
		{
			System.out.println("Running");
			try {
				throw new Exception("Exception");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		);
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
				System.out.println("HIII");
			}
			
		});
		t.start();
		//t.interrupt();
	}

}
