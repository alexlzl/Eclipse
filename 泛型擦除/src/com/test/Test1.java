package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这就是Java泛型的类型擦除造成的，因为不管是ArrayList<Integer>()还是new
 * ArrayList<String>()，都在编译器被编译器擦除成了ArrayList。那编译器为什么要做这件事？原因也和大多数的Java让人不爽的点一样——兼容性。由于泛型并不是从Java诞生就存在的一个特性，而是等到SE5才被加入的，所以为了兼容之前并未使用泛型的类库和代码，不得不让编译器擦除掉代码中有关于泛型类型信息的部分，这样最后生成出来的代码其实是『泛型无关』的，我们使用别人的代码或者类库时也就不需要关心对方代码是否已经『泛化』，反之亦然。
 * 
 * @author liuzhouliang
 *
 */
public class Test1<T> {

	public Test1() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] str) {
		Class c1 = new ArrayList<Integer>().getClass();
		Class c2 = new ArrayList<String>().getClass();
		System.out.println(c1 == c2);// true

		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
		System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
		/**
		 * [E] [K, V]
		 */

	}

	/*
	 * 我们无法在泛型内部创建一个T类型的数组，原因也和之前一样，T仅仅是个占位符，并没有真实的类型信息，实际上，除了new表达式之外，
	 * instanceof操作和转型（会收到警告）在泛型内部都是无法使用的，而造成这个的原因就是之前讲过的编译器对类型信息进行了擦除。
	 */

	// public T[] makeArray() {
	// // error: Type parameter 'T' cannot be instantiated directly
	// return new T[5];
	// }
}
