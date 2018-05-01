package com.java.basic;

public class Common implements Cloneable{
	  //Default version of clone() method. It creates shallow copy of an object.
	 
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
