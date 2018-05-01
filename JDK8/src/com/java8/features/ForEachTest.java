package com.java8.features;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ForEachTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		
		Set<Common> commonSet = new TreeSet<>();
		commonSet.add(new Common("Bala","101"));
		commonSet.add(new Common("Meena","102"));
		commonSet.add(new Common("Bala","101"));
		
		Iterator i = set.iterator();
/*		while(i.hasNext()) {
			i.next();
			System.out.println("III");
			i.remove();
		}*/
		
		set.forEach(new Consumer<String>() {
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		commonSet.forEach(new ConsumerClass());
		
		commonSet.forEach(new Consumer<Common>() {
			public void accept(Common s) {
				System.out.println(s.getName());
			}
		});
	}
	
}
