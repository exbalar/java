package com.java.basic.regex;

public class StringReplaceTest {

	public static void main(String[] args) {
		String text = "abcDeejjabcii kk 12llFjiFaF";
		System.out.println(text.replaceAll(".", "X"));
		System.out.println(text.replaceAll("^abc", "YYY"));
		System.out.println(text.replaceAll("FaF$", "ZZZ"));
		System.out.println(text.replaceAll("[aei]", "O"));
		System.out.println(text.replaceAll("[aei][b]", "U"));
		System.out.println(text.replaceAll("^[aei][b]", "PP"));
		System.out.println(text.replaceAll("[a][F]$", "O"));
		System.out.println(text.replaceAll("[a]bc", "@"));
		System.out.println(text.replaceAll("[^ab]", "#"));
		System.out.println(text.replaceAll("[a-z0-9]", "%"));
		System.out.println(text.replaceAll("(?i)[a-z0-9]", "%"));
		System.out.println(text.replaceAll("\\d", "Q"));
		System.out.println(text.replaceAll("\\D", "Q"));
		System.out.println(text.replaceAll("\\s", "Q"));
		System.out.println(text.replaceAll("\\S", "Q"));
		System.out.println(text.replaceAll("\\w", "*"));
		System.out.println(text.replaceAll("\\b", "!"));
		
		
	}

}
