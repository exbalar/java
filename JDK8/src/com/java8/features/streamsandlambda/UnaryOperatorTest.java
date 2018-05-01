package com.java8.features.streamsandlambda;

import java.util.function.IntUnaryOperator;

public class UnaryOperatorTest {

	public static void main(String[] args) {

		IntUnaryOperator opr = num -> {
			return ++num;
		};
		System.out.println(opr.applyAsInt(10));
	}

}
