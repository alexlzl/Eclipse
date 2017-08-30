package com.test;
/**
 * Java 5新增的enum关键词，可以定义枚举类。该类是一个特殊的类，可以定义自己的field、方法、可以实现接口，也可以定义自己的构造器。但枚举类使用enum定义后在编译后默认继承了java.lang.Enum类，而不是普通的继承Object类。enum声明类继承了Serializable和Comparable两个接口。且采用enum声明后，该类会被编译器加上final声明（同String），故该类是无法继承的。枚举类的内部定义的枚举值就是该类的实例（且必须在第一行定义，当类初始化时，这些枚举值会被实例化）。由于这些枚举值的实例化是在类初始化阶段，所以应该将枚举类的构造器（如果存在），采用private声明（这种情况下默认也是private）。另外补充一点，由于JVM类初始化是线程安全的，所以可以采用枚举类实现一个线程安全的单例模式。


 * @author liuzhouliang
 *
 */
public enum TestEnum implements TestInterface{
	
	INSTANCE;
	public String test(){
		System.out.print("调用test===");
		return "返回";
	}

}
