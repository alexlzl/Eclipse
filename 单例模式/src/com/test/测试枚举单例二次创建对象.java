package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Exception in thread "main" java.lang.NoSuchMethodException:
 * com.effective.singleton.SingletonClass.<init>() at
 * java.lang.Class.getConstructor0(Unknown Source) at
 * java.lang.Class.getDeclaredConstructor(Unknown Source) at
 * com.effective.TestMain.main(TestMain.java:22) 由此可见这种写法也可以防止单例模式被“攻击”。
 * 而且这种写法也可以防止序列化破坏单例模式，
 * 
 * @author liuzhouliang
 *
 */

public class 测试枚举单例二次创建对象 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<枚举单例> classType = 枚举单例.class;
		Constructor<枚举单例> c = (Constructor<枚举单例>) classType.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
	}
}
