package com.test;

public class 防止反射二次创建对象 {
	private static boolean flag = false;

	private 防止反射二次创建对象() {
		synchronized (防止反射二次创建对象.class) {
			if (flag == false) {
				flag = !flag;
			} else {
				throw new RuntimeException("单例模式被侵犯！");
			}
		}
	}

	private static class SingletonHolder {
		private static final 防止反射二次创建对象 INSTANCE = new 防止反射二次创建对象();
	}

	public static 防止反射二次创建对象 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void doSomethingElse() {

	}
}
