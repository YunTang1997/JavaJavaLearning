package start.java;

/**
 * @author YunTang
 * @create 2020-07-19 10:26
 */

/*
1. 类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能[存在一个对象实例]。

2. 如何实现？
    饿汉式  vs 懒汉式

3. 区分饿汉式 和 懒汉式
   饿汉式：
      	坏处：对象加载时间过长。
    	好处：饿汉式是线程安全的

   懒汉式：好处：延迟对象的创建。
 		  目前的写法坏处：线程不安全。--->到多线程内容时，再修改
 */

public class SingletonTest1 {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
        System.out.println(instance1 == instance2);
    }
}

// 饿汉式
class Bank{

    // 1.私有化类的构造器
    private Bank(){
    }

    // 2.内部创建实例对象
    // 4.要去此对象也必须声明为静态的
    private static Bank instance = new Bank();

    // 3.提供公共的[静态]方法，返回类的实例
    public static Bank getInstance(){
        return instance;
    }


}
