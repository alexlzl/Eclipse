package com.test;

import java.lang.reflect.Constructor;

public class 测试二次创建对象 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try 
	        {  
	            Class<防止反射二次创建对象> classType = 防止反射二次创建对象.class;  
	 
	            Constructor<防止反射二次创建对象> c = classType.getDeclaredConstructor(null);  
	            c.setAccessible(true);  
	            防止反射二次创建对象 e1 = (防止反射二次创建对象)c.newInstance();  
	            防止反射二次创建对象 e2 = 防止反射二次创建对象.getInstance();  
	            System.out.println(e1==e2);  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	}

}
