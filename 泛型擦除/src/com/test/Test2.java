package com.test;
/**
 * 虽然有类型擦除的存在，使得编译器在泛型内部其实完全无法知道有关T的任何信息，但是编译器可以保证重要的一点：内部一致性，也是我们放进去的是什么类型的对象，取出来还是相同类型的对象，这一点让Java的泛型起码还是有用武之地的。

代码片段四展现就是编译器确保了我们放在t上的类型的确是T（即便它并不知道有关T的任何类型信息）。这种确保其实做了两步工作：

set()处的类型检验
get()处的类型转换
这两步工作也成为边界动作
 * @author liuzhouliang
 *
 * @param <T>
 */
public class Test2<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Test2<String> m = new Test2<String>();
        m.set("findingsea");
        String s = m.get();
        System.out.println(s);
    }
}

