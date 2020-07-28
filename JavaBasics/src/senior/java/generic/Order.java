package senior.java.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 自定义泛型类
 * @author YunTang
 * @create 2020-07-28 11:03
 */

public class Order<T> {

    String orderName;
    int orderId;

    // 类的内部结构就可以使用类的泛型
    T orderT;

    // 编译不通过
//    T[] arr = new T[10];
    // 编译通过
//    T[] arr = (T[])new Object[10];

    public Order(){

    }

    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    // 如下三个方法均不是泛型方法
    public T getOrderT(){
        return this.orderT;
    }

    public void setOrderT(T orderT){
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不能使用泛型，因为泛型是实例化的时候才指定类型，但是静态方法随类的加载而加载
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    // 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    // 换句话说，泛型方法所属的类是不是泛型类都没有关系。
    // 泛型方法，可以声明为静态的。原因：泛型参数是在[调用方法时]确定的，并非在实例化类时确定。
    public static <E> ArrayList<E> copyFromArrayToList(E[] arr){ // 第一个<E>使得编译器知道E指的不是一个具体的类，而是指的泛型

        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}
