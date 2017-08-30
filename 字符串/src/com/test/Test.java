package com.test;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class Test {
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s="abc";
		 String sn=String.valueOf(1);
		  System.out.println(sn);
		String sb1=String.valueOf(true);
		  System.out.println(sb1);
//		 s.toString();
		List<Test> list=new ArrayList<Test>();
		for(int i=0;i<10;i++){
			list.add(new Test());
		}
       System.out.println(list);
       
    StringBuilder sb = new StringBuilder();


  Formatter formatter = new Formatter(sb, Locale.US);

  
   formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");

   System.out.println(formatter);//d  c  b  a
	}

}
