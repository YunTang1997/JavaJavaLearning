package start.java;

/**
 * @author YunTang
 * @create 2020-07-05 15:28
 */

/*
Java面向对象学习的三条主线：
 1.Java类及类的成员：属性、方法、构造器；代码块、内部类
 2.面向对象的三大特征：封装性、继承性、多态性、(抽象性)
 3.其它关键字：this、super、static、final、abstract、interface、package、import等

一、设计类，其实就是设计类的成员
    属性 = 成员变量 = field = 域、字段
    方法 = 成员方法 = 函数 = method
    创建类的对象 = 类的实例化 = 实例化类

二、类和对象的使用（面向对象思想落地的实现）：
    1.创建类，设计类的成员
    2.创建类的对象
    3.通过“对象.属性”或“对象.方法”调用对象的结构

三、如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性。（非static的）
    意味着：如果我们修改一个对象的属性a，则不影响另外一个对象属性a的值。

四、对象的内存解析

 */

/*
类中属性的使用：
属性（成员变量） vs  局部变量
1.相同点：
    1.1 定义变量的格式：数据类型 变量名 = 变量值
    1.2 先声明，后使用
    1.3 变量都有其对应的作用域


2.不同点：
2.1 在类中声明的位置的不同
    属性：直接定义在类的一对{}内
	局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量

2.2 关于权限修饰符的不同
 	属性：可以在声明属性时，指明其权限，使用权限修饰符。
		常用的权限修饰符：private、public、缺省、protected  --->封装性
		目前，大家声明属性时，都使用缺省就可以了。

 	局部变量：不可以使用权限修饰符。

2.3 默认初始化值的情况：
    属性：类的属性，根据其类型，都有默认初始化值。
        整型（byte、short、int、long）：0
        浮点型（float、double）：0.0
        字符型（char）：0  （或'\u0000'）
 		布尔型（boolean）：false

  		引用数据类型（类、数组、接口）：null

    局部变量：没有默认初始化值。意味着，我们在调用局部变量之前，一定要显式赋值。特别地：形参在调用时，我们赋值即可。

2.4 在内存中加载的位置：
    属性：加载到堆空间中（非static）
    局部变量：加载到栈空间
 */

// 测试类
public class PersonTest {
    public static void main(String[] args){

        // 创建Person类的实例对象
        Person p1 = new Person();

        // 调用属性（对象名.属性名）
        p1.name = "Tom";
        p1.age = 18;
        p1.isMale = true;
        System.out.println(p1.name);

        // 调用方法（对象名.方法名）
        p1.eat();
        p1.talk("chinese");
        p1.sleep();
    }
}

// 创建类
class Person{

    // 创建属性（成员变量）
    String name;
    int age;
    boolean isMale;

    // 创建方法
    public void eat(){
        System.out.println("人需要吃饭");
    }
    public void talk(String language){ // language为局部变量
        System.out.println("人可以说话，使用的语言是：" + language);
    }
    public void sleep(){
        System.out.println("人需要睡觉");
    }
}