package com.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Test {
	/***
	 * 在程序中定义了一个ArrayList泛型类型实例化为Integer的对象，如果直接调用add方法，那么只能存储整形的数据。不过当我们利用反射调用add方法的时候，却可以存储字符串。这说明了Integer泛型实例在编译之后被擦除了，只保留了原始类型。
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
		arrayList3.add(1);// 这样调用add方法只能存储整形，因为泛型类型的实例为Integer
		arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
		for (int i = 0; i < arrayList3.size(); i++) {
			System.out.println(arrayList3.get(i));
		}

	}
}
