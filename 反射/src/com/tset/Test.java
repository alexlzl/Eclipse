package com.tset;

public class Test {
  public static class Foo{
	  
  }
  
  public static void main(String[] str){
	  Class<Test> c=Test.class;
	  Class[] cc=c.getDeclaredClasses();
	  for(int i=0;i<cc.length;i++){
		  System.out.println(c.getName());
	  }
	
  }
}
