package com.java8.features.streamsandlambda;

import java.util.ArrayList;
import java.util.List;

public class ConsumerTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Bala");
		list.add("Meena");
		list.add("Raja");
		list.add("AAA");
		list.forEach(name -> {
			if(name.equals("Bala")) {
			System.out.println(name);
			}
			});
	}

}
