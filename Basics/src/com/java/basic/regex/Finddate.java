package com.java.basic.regex;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finddate {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		Pattern p = Pattern.compile("(\\d{2})\\-(\\d{2})\\-(\\d{4})") ;
		Matcher m = p.matcher("10-10-1986te10-10-1986 .and 10-10-1986 meena 11-02-1990. yes");
		while (m.find()) {
			set.add(m.group().split("-")[2]);
		}
		System.out.println(set.size());
	}

}
