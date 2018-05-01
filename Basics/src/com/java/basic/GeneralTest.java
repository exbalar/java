package com.java.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
public class GeneralTest {

	
	static void collectionstest() {
		HashMap<String,String> map = new HashMap<>();
		map.put(null, null);
		map.put(null, null);
		map.put(null, null);
		System.out.println("ss");
		
		/*TreeMap<Common,String> tmap = new TreeMap<>();
		tmap.put(new Common(), null);
		tmap.put(null, null);
		tmap.put(null, null);
		System.out.println("ss");*/
		
		LinkedHashMap<Common,String> lmap = new LinkedHashMap<>();
		lmap.put(null, null);
		lmap.put(null, null);
		lmap.put(null, null);
		System.out.println("ss");
		
		
		Hashtable<String,String> hmap = new Hashtable<>();
		/*hmap.put(null, null);
		hmap.put(null, null);
		hmap.put(null, null);*/
		System.out.println("ss");
		
		
		ConcurrentHashMap<String,String> cmap = new ConcurrentHashMap<>(10,10.0f,10);
		/*cmap.put(null, null);
		cmap.put(null, null);
		cmap.put(null, null);*/
		System.out.println("ss");
		Map<String,String> m = Collections.synchronizedMap(cmap);
		/*m.put(null,null);*/
		
		
		HashSet<Common> hset = new HashSet<>();
		hset.add(new Common());
		System.out.println("ss");
		
		TreeSet<Common> tset = new TreeSet<>();
		tset.add(new Common());
		System.out.println("ss");
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException {

		Class<?> clas = Class.forName("com.test.basics.Common");
		Constructor<?> con = clas.getConstructor();
		Common c1 = (Common)con.newInstance();
		Common c2 = (Common) clas.newInstance();
		Common c = (Common) Class.forName("com.test.basics.Common").newInstance();
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2.clone());
		
		
	}

}
