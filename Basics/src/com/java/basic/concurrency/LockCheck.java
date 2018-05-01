package com.java.basic.concurrency;

import java.util.Hashtable;
import java.util.TreeSet;

public class LockCheck {

	public static void main(String[] args) {
		Hashtable<String,String> ht = new Hashtable<String,String>();
		TreeSet hs = new TreeSet<>();
		if(Thread.holdsLock(new LockCheck())) {
			System.out.println("hi");
		}
	}

}
