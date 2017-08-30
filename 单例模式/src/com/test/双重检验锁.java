package com.test;

/**
 * 这段代码看起来很完美，很可惜，它是有问题。主要在于instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM
 * 中这句话大概做了下面 3 件事情。
 * 
 * 给 instance 分配内存 调用 Singleton 的构造函数来初始化成员变量 将instance对象指向分配的内存空间（执行完这步
 * instance 就为非 null 了） 但是在 JVM
 * 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是
 * 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null
 * 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。 有些人认为使用 volatile
 * 的原因是可见性，也就是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取。但其实是不对的。使用 volatile
 * 的主要原因是其另一个特性：禁止指令重排序优化。也就是说，在 volatile
 * 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会被重排序到内存屏障之前。比如上面的例子，取操作必须在执行完 1-2-3 之后或者
 * 1-3-2 之后，不存在执行到 1-3 然后取到值的情况。从「先行发生原则」的角度理解的话，就是对于一个 volatile
 * 变量的写操作都先行发生于后面对这个变量的读操作（这里的“后面”是时间上的先后顺序）。
 * 
 * 但是特别注意在 Java 5 以前的版本使用了 volatile 的双检锁还是有问题的。其原因是 Java 5 以前的 JMM （Java
 * 内存模型）是存在缺陷的，即时将变量声明成 volatile 也不能完全避免重排序，主要是 volatile 变量前后的代码仍然存在重排序问题。这个
 * volatile 屏蔽重排序的问题在 Java 5 中才得以修复，所以在这之后才可以放心使用 volatile。
 * 
 * @author lzl
 *
 */
public class 双重检验锁 {
	private volatile static 双重检验锁 instance; // 声明成 volatile

	private 双重检验锁() {
	}

	/**
	 * 为什么需要2次判断是否为空呢？第一次判断是为了避免不必要的同步，第二次判断是确保在此之前没有其他线程进入到sychronized块创建了新实例。这段代码看上去非常完美，但是，，，却有隐患！问题出现在哪呢？主要是在instance=new
	 * Singleton();这段代码上。这段代码会编译成多条指令，大致上做了3件事:
	 * 
	 * （1）给Singleton实例分配内存 （2）调用Singleton()构造函数，初始化成员字段
	 * （3）将instance对象指向分配的内存（此时instance就不是null啦~）
	 * 上面的（2）和（3）的顺序无法得到保证的，也就是说，JVM可能先初始化实例字段再把instance指向具体的内存实例，也可能先把instance指向内存实例再对实例进行初始化成员字段。考虑这种情况：一开始，第一个线程执行instance=new
	 * Singleton();这句时，JVM先指向一个堆地址，而此时，又来了一个线程2，它发现instance不是null，就直接拿去用了，但是堆里面对单例对象的初始化并没有完成，最终出现错误~
	 * 。
	 * 
	 * 相比前面的代码，这里只是对instance变量加了一个volatile关键字volatile关键字的作用是：线程每次使用到被volatile关键字修饰的变量时，都会去堆里拿最新的数据。换句话说，就是每次使用instance时，保证了instance是最新的。注意：volatile关键字并不能解决并发的问题，关于volatile请查看其它相关文章。但是volatile能解决我们这里的问题。
	 * 
	 * @return
	 */
	public static 双重检验锁 getSingleton() {
		if (instance == null) {
			synchronized (双重检验锁.class) {
				if (instance == null) {
					instance = new 双重检验锁();
				}
			}
		}
		return instance;
	}
}
