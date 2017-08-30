package com.test;

public class Test  implements ITest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		枚举单例 ts=	枚举单例.INSTANCE;
		枚举单例 ts1=枚举单例.TEST;
		ts.test();
		ts1.test1();
		静态内部类.getInstance().test();
	}
	
	protected void test(){
		
	}
	

}
