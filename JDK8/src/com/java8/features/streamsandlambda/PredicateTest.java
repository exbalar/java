package com.java8.features.streamsandlambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

	private static void compare(BiPredicate<String,Integer> predicate, BiPredicate<String,Integer> p2,List<String> l) {
/*		for(String s: l) {
			if (predicate.test(s) ) {
				System.out.println(s);
			}
		}*/
		
		l.forEach(action -> {
			if(p2.or(predicate).test(action,12)) {
				System.out.println(action);
			}
		});
	}
	public static void main(String[] args) {


		List<String> list = new ArrayList<>();
		list.add("Bala");
		list.add("Meena");
		list.add("Raja");
		list.add("AAA");

		BiPredicate<String,Integer> p  = (text,num) -> {
			if(text.contains("a")) {
				return true;
			}
			return false;
		};
		BiPredicate<String,Integer> p2  = (text,num) -> {
			if(text.contains("B")) {
				return true;
			}
			return false;
		};
		
		compare(p,p2,list);
	
	}

}
