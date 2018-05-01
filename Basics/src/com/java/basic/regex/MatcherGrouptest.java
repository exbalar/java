package com.java.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherGrouptest {
	
	static String text = "<h1> This is a title </h1> <p> this is a paragraph about something </p>"
			+ "<h2>Sub title</h2> <p> Another paragraph </p> <h2> Summary</h2>"
			+ "<p> Summary text </p>";

	private static void simplepatter() {

		String patternString = "<h2>";
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			System.out.println("Occurance::" + matcher.start() + "End::" + matcher.end());
			System.out.println(matcher.group());
			System.out.println(matcher.group(0));
			
		}
	}
	
	private static void grouppattern() {

		String patternString = "(<h2>)(.*?)(</h2>)";
		
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			System.out.println("Occurance::" + matcher.start() + "End::" + matcher.end());
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
		}
	}
	public static void main(String[] args) {

		//simplepatter();
		grouppattern();
		
		
	}

}
