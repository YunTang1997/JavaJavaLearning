package start.java;

import org.junit.jupiter.api.Test;

import javax.security.auth.Subject;
import javax.xml.transform.Source;

/**
 * @author YunTang
 * @create 2020-07-19 15:16
 */

/*
 * abstract关键字的使用
 * 1.abstract:抽象的
 * 2.abstract可以用来修饰的结构：类、方法
 *
 * 3. abstract修饰类：抽象类
 * 		> 此类不能实例化
 *      > 抽象类中一定有构造器，便于[子类]实例化时调用（涉及：子类对象实例化的全过程）
 *      > 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
 *
 *
 * 4. abstract修饰方法：抽象方法
 * 		> 抽象方法只有方法的声明，[没有方法体]
 * 		> [包含抽象方法的类，一定是一个抽象类]。反之，抽象类中可以没有抽象方法的。
 *      > 若子类[重写了父类(直接或间接)中的[所有的]抽象方法]后，此子类方可实例化
 *        若子类[没有重写父类中的所有的抽象方法]，则此子类也是一个抽象类，需要使用abstract修饰
 *
 * 5. abstract使用上的注意点：
 *      ①abstract不能用来修饰：属性、构造器等结构
 *
 *      ②abstract不能用来修饰私有方法、静态方法、final的方法、final的类
 */

public class AbstractTest {

    public static void main(String[] args) {

        // 一旦Person2类抽了，就不可以[调用自身的构造器]进行实例化了
//        Person2 person2 = new Person2();
//        person2.eat();
    }
}

abstract class Person2{
    String name;
    int age;

    public Person2(){

    }

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

//    public void eat(){
//        System.out.println("人吃饭");
//    }

//    // 不是抽象方法
//    public void eat(){
//
//    }

    // 抽象方法（不允许对象调用此抽象方法，所以一般含有抽象方法的类，一定是抽象类）
    public abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }

}

class Student2 extends Person2{

    public Student2(String name, int age){
        super(name, age);
    }

    @Override
    public void eat(){
        System.out.println("学生多吃饭");
    }
}


