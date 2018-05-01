package com.java8.features.streamsandlambda;

interface Lam {
	public String getString(String a);
	//public String getInteger(String a);
}
public class LambdaTest {

	public static void main(String[] args) {

		Lam lam = a -> {
			System.out.println("Inside lambda");
			return a.toUpperCase();
		};
		System.out.println(lam.getString("bala"));
	}

}
