package com.java.basic.oops;

class A extends B {


}
class B {
	public  static void test (String a) {
		System.out.println("static");
	}
	void add (String a) {
		System.out.println("AA");
	}
	void add (Object a) {
		System.out.println("BB");
	}
	void add (long l) {
		System.out.println("AA");
	}
	void add (double d) {
		System.out.println("BB");
	}
}
public class OOPsTest {

	public static void main(String[] args) {
		B b = new A();
		new B().add(5);
		boolean bb = (10 == 0);
		if(bb)	return;
		System.out.println();
	}

}
