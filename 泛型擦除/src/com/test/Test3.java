package com.test;
/**
 * 如上看到的，但凡是涉及到确切类型信息的操作，在泛型内部都是无法共工作的。那是否有办法绕过这个问题来编程，答案就是显示地传递类型标签。
 * @author liuzhouliang
 *
 * @param <T>
 */

public class Test3<T> {

	 public T create(Class<T> type) {
	        try {
	            return type.newInstance();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public static void main(String[] args) {
	    	Test3<String> m = new Test3<String>();
	        String s = m.create(String.class);
	    }

}
