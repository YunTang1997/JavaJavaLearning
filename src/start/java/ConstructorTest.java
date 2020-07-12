package start.java;

/**
 * @author YunTang
 * @create 2020-07-12 19:03
 */

/*
类的结构之三：构造器（或构造方法、constructor）的使用

一、构造器的作用：
1.创建对象
2.初始化对象的信息

二、说明：
1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
2.定义构造器的格式：权限修饰符  类名(形参列表){}
3.一个类中定义的多个构造器，彼此构成重载
4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
5.一个类中，至少会有一个构造器。
 */

public class ConstructorTest {

    public static void main(String[] args) {

        //创建对象:new + 构造器
        PersonNew person1 = new PersonNew(); // PersonNew()就是构造器
        person1.eat();

        PersonNew person2 = new PersonNew("Tom");

        PersonNew person3 = new PersonNew("Lily", 16);
    }

}

class PersonNew{
    // 属性
    private String name;
    private int age;

    // 构造器
    public PersonNew(){
        System.out.println("Person().....");
    }

    public PersonNew(String n){
        name = n;

    }

    public PersonNew(String n,int a){
        name = n;
        age = a;
    }

    // 方法
    public void eat(){
        System.out.println("人需要吃饭");
    }

    public void sleep(){
        System.out.println("人需要睡觉");
    }
}

