package senior.java.generic;

import java.util.ArrayList;

/**
 * @author YunTang
 * @create 2020-07-28 13:24
 */
public class SubOrder extends Order<Integer>{ // SubOrder:不是泛型类

    // 泛型方法
    public static <E> ArrayList<E> copyFromArrayToList(E[] arr){ // 第一个<E>使得编译器知道E指的不是一个具体的类，而是指的泛型

        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}
