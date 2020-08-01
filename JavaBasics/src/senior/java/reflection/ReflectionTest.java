package senior.java.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
 * 建议：直接new的方式。
 *
 * 什么时候会使用：反射的方式。（编译时不决定要造哪个类的对象） 反射的特征：动态性
 *
 * 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
 * 不矛盾。
 * @author YunTang
 * @create 2020-08-01 9:58
 */

public class ReflectionTest {

    // 反射之前，对于Person的操作
    @Test
    public void test1(){

        // 1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        // 2.通过对象，调用其内部的属性和方法
        p1.age = 10;
        System.out.println(p1.toString());
    }

    // 在Person类的外部，不可以通过Person类的对象调用其内部的私有结构
    // name、showNation()以及私有的构造器

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;

        // 1.通过反射，创建Person类的对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());

        // 2.通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*********************");

        // 通过反射，可以调用Person类的私有结构。比如：私有的构造器、方法、属性
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class); // 调用私有构造器
        constructor1.setAccessible(true);
        Person p1 = (Person) constructor1.newInstance("Jerry");
        System.out.println(p1);

        // 调用私有结构的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Tony");
        System.out.println(p1.toString());

        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国"); // 相当于p1.showNation("中国")
        System.out.println(nation);
    }

    /*
    关于java.lang.Class类的理解
    1.类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
    接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
    加载到内存中。此过程就称为类的加载。[加载到内存中的类，我们就称为运行时类]，此
    运行时类，就作为Class的一个实例。

    2.换句话说，Class的实例就对应着一个运行时类。

    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
     */

    // 获取Class的实例（运行时类）的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {

        // 通过运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        // 通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 通过class的静态方法：forName(String classPath)（该方法使用的频率较高）
        Class clazz3 = Class.forName("senior.java.reflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        // 方式四：使用类的加载器：ClassLoader（了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader(); // 获得Reflection运行时类对象的加载器
        Class clazz4 = classLoader.loadClass("senior.java.reflection.Person"); // 利用获得的加载器加载Person类
        System.out.println(clazz4);

    }

    // Class实例可以是哪些结构的说明
    @Test
    public void test4(){

        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的[元素类型]与[维度]一样，就是同一个Class
        System.out.println(c10 == c11);

    }

}
