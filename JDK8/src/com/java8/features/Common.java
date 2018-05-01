package com.java8.features;

public class Common implements Comparable{
	
	private String name;
	private String id;
	
	public Common(String name,String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return (((Common)obj).getName().equals(this.getName())) ? true : false;
	}
	@Override
	public int compareTo(Object o) {
		if(((Common)o).equals(this)) {
			return 0;
		}
		return 1;
	}
	

}
