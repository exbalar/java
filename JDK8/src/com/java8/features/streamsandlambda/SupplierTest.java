package com.java8.features.streamsandlambda;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		Supplier<Integer> sup = () -> new Random().nextInt(100);
		System.out.println(sup.get());
	}

}
