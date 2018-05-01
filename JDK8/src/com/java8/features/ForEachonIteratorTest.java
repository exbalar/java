package com.java8.features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MyConsumer implements Consumer<String>{

	Integer i = 0;
	public void add(Integer i){
		this.i = this.i.intValue() + i.intValue();
	}
	@Override
	public void accept(String arg0) {
		
		this.add(Integer.parseInt(arg0));
		
	}
	
	
}

public class ForEachonIteratorTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		final List<String> listL = new ArrayList<>();
		list.add("1");
		list.add("2");
		
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String arg0) {
				listL.add(arg0);
			}
			
		});
		
		System.out.println(listL);
		
		List<Integer> listI = new ArrayList<>();
		listI.add(1);
		listI.add(2);
		listI.add(3);
		MyConsumer my = new MyConsumer();
		list.forEach(my);
		System.out.println(list+"listI"+ my.i);
		
	}

}
