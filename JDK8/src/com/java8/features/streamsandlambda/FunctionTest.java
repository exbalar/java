package com.java8.features.streamsandlambda;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		Function<String, Integer> func = text -> {
			if (text.contains("s")) {
				return 12;
			}
			return 13;
		};
		
		System.out.println(func.apply("Bala"));
		
	}

}
