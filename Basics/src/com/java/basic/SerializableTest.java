package com.java.basic;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class C {
	public int a = 10;
	public static void a() {
		System.out.println("C");
	}
}
class B  extends C implements Serializable{
	public int a = 20;
	
	public static void a() {
		System.out.println("B");
	}
	//private C c = new C();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
class A implements Externalizable{
	
	private C c = new C ();
	
	private static final long serialVersionUID = -4056141248875769563L;
	public A() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(this);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		in.readObject();
		
	}
	
}



public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		B a= new B();
		System.out.println(a.a);
		a.a();
		FileOutputStream fo = new FileOutputStream("C:\\Users\\SUBRAM~1.RAM\\AppData\\Local\\Temp\\object.txt");
		
		ObjectOutputStream out = new ObjectOutputStream(fo);
		
		out.writeObject(a);
		fo.close();
		
		FileInputStream fi = new FileInputStream(new File("C:\\Users\\SUBRAM~1.RAM\\AppData\\Local\\Temp\\object.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);
		System.out.println(oi.readObject().hashCode());
	}

}
