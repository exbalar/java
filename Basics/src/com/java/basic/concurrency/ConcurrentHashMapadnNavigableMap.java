package com.java.basic.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentHashMapadnNavigableMap {

	
	static void concurrentHashMap(){
		ConcurrentMap<String, String> conHashMap = new ConcurrentHashMap<>(12,0.2f,12);
		conHashMap.put("1", "A");
		conHashMap.put("2", "B");
		conHashMap.put("3", "C");
		Iterator iterator = conHashMap.keySet().iterator();
		while(iterator.hasNext()){
			String s = (String)iterator.next();
			conHashMap.put("1", "D");
		}
	}
	
	static void hashMap(){
		Map<String, String> conHashMap = new HashMap<>();
		conHashMap.put("1", "A");
		conHashMap.put("2", "B");
		conHashMap.put("3", "C");
		Iterator iterator = conHashMap.keySet().iterator();
		while(iterator.hasNext()){
			String s = (String)iterator.next();
			conHashMap.put("3", "D");
		}
	}
	
	static void concurrentNavigablehashMap(){
		ConcurrentNavigableMap<String, String> conHashMap = new ConcurrentSkipListMap<>();
		conHashMap.put("1", "A");
		conHashMap.put("2", "B");
		conHashMap.put("3", "C");
		Iterator iterator = conHashMap.headMap("3").keySet().iterator();
		while(iterator.hasNext()){
			String s = (String)iterator.next();
			conHashMap.put("4", "D");
		}
	}
	
	public static void main(String[] args) {
		concurrentHashMap();
		hashMap();
		concurrentNavigablehashMap();
	}

}
