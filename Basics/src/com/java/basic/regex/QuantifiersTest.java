package com.java.basic.regex;

public class QuantifiersTest {

	public static void main(String[] args) {


		String text = "abcDeeejjabcii kk 12llFjiFaF";
		System.out.println(text.replaceAll("De{3}jj", "X"));
		System.out.println(text.replaceAll("De{1,3}", "X"));
		System.out.println(text.replaceAll("De+", "X"));
		System.out.println(text.replaceAll("De*", "X"));
		System.out.println(text.replaceAll("abcDe+j*abci+\\sk+\\s12l+Fji", "X"));
		System.out.println(text.replaceAll("abcDe+j*abci+\\sk+\\s12l*Fji", "X"));
		
		
		
	
	}

}
