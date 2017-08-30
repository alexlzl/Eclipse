package com.test;

import java.util.Arrays;

/**
 * 二维简单数据类型数组的动态初始化如下, int a[ ][ ] = new int[2][ ]； a[0] = new int[3]; a[1] =
 * new int[5];
 * 
 * 对二维复合数据类型的数组，必须首先为最高维分配引用空间，然后再顺次为低维分配空间。 而且，必须为每个数组元素单独分配空间。
 * 
 * @author liuzhouliang
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s[][] = new String[2][];
		s[0] = new String[2];// 为最高维分配引用空间
		s[1] = new String[2]; // 为最高维分配引用空间
		s[0][0] = new String("Good");// 为每个数组元素单独分配空间
		s[0][1] = new String("Luck");// 为每个数组元素单独分配空间
		s[1][0] = new String("to");// 为每个数组元素单独分配空间
		s[1][1] = new String("You");// 为每个数组元素单独分配空间
		System.out.println(Arrays.deepToString(s));
	}

}
