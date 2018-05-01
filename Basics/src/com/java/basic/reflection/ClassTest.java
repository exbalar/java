package com.java.basic.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		System.out.println(ClassTest.class.newInstance());
		Class c = ClassTest.class;
		System.out.println(c.getClassLoader().getParent());
		System.out.println(c.getSuperclass());
		//System.out.println(c.getMethod("main",Class<String[]> c));
		for(Method m : c.getMethods()) {
			System.out.println("method name::"+m.invoke(new ClassTest(), ""));
			System.out.println("method param type::"+m.getParameterTypes());
			//System.out.println(m.invoke(new ClassTest(), null));
		}
		
	}

}
