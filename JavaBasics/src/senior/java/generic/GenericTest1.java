package senior.java.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 1.泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>。
 *
 * 2.泛型类的构造器如下：public GenericClass(){}。而下面是错误的：public GenericClass<E>(){}。
 *
 * 3.实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 *
 * 4.泛型不同的引用不能相互赋值。
 *   尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 *
 * 5.泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。经验：泛型要使用，一路都用。要不用，一路都不要用。
 *
 * 6.如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 *
 * 7.jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>()。（类型推断）
 *
 * 8.泛型的指定中不能使用基本数据类型，可以使用[包装类]替换。
 *
 * 9.在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为[非静态]属性的类型、[非静态]方法的参数类型、[非静态]方法的返回值类型。
 *   但在[静态方法]中[不能]使用类的泛型。
 *
 * 10.异常类不能是泛型的。
 *
 * 11.不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity]。
 *    参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
 *
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
 *     子类不保留父类的泛型：按需实现
 *        没有类型 擦除
 *        具体类型
 *     子类保留父类的泛型：泛型子类
 *        全部保留
 *        部分保留
 * 结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型。
 * @author YunTang
 * @create 2020-07-28 11:09
 */

public class GenericTest1 {

    @Test
    public void test1(){

        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        // 要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        // 建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("AA", 1001, "Tom");
    }

    @Test
    public void test2(){

        // 由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(122);

        SubOrder1<String> SubOrder1 = new SubOrder1<>();
        SubOrder1.setOrderT("Tony......");

    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        // 泛型不同的引用不能相互赋值。
//        list1 = list2;

    }

    // 泛型方法测试
    @Test
    public void test4(){

        Order<String> order = new Order<>();
        // 泛型方法在调用时，指明泛型的类型
        ArrayList<Integer> list = order.copyFromArrayToList(new Integer[]{1, 2, 3});
        System.out.println(list);

    }
}
