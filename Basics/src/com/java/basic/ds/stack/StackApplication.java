package com.java.basic.ds.stack;

import java.util.Stack;

public class StackApplication {
	
	public static boolean checkIfclosed(String input) {
		//char arrr[] = input.split(regex)
		Stack<Character> s = new Stack<>();
		for (int i =0 ; i < input.length()-1 ; i++) {
			
			if (input.charAt(i) == '>') {
				if (s.peek() == '<') {
					s.pop();
				}
			} else {
				s.push(input.charAt(i));
			}
		}
		if (s.isEmpty()) {
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {

		System.out.println(checkIfclosed("<<<<<<>>>"));
	}

}
