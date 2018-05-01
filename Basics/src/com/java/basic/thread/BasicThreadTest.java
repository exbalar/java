package com.java.basic.thread;

class A extends Thread{
    public void run(){
          for(int i=0; i<2; i++){
                System.out.println(i);
          }
    }
}

public class BasicThreadTest{
    public static void main(String argv[]){
          BasicThreadTest t = new BasicThreadTest();
          t.check(new A());
    }
    public void check(A a){
    	System.out.println(a.isAlive());
          a.start();
          System.out.println(a.isAlive());
    }
}