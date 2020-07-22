package senior.java.collection.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author YunTang
 * @create 2020-07-21 18:52
 */

/*
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int index, Object ele)
查：get(int index)
插：add(int index, Object ele)
长度：size()
遍历：① Iterator迭代器方式
     ② 增强for循环
     ③ 普通的循环
 */

public class ListMethodsTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(456);
        list.add("AA");
        list.add(new Date());

        System.out.println(list);

        // void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        // boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List<Integer> list1 = Arrays.asList(1, 2, 3);
//        list.addAll(list1); // 默认添加在末尾
        list.addAll(0, list1);
        System.out.println(list);

        // Object get(int index):获取指定index位置的元素
        Object o = list.get(0);
        System.out.println(o);
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(456);
        list.add("AA");
        list.add(new Date());

        // int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        int i = list.indexOf(456);
        System.out.println(i);

        // 返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
        int j = list.lastIndexOf("AA");
        System.out.println(j);

        // Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = list.remove(0);
//        Object remove1 = list.remove(new Integer(456)); // 按成员删除
        System.out.println(remove);

        // Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1, "CC");
        System.out.println(list);

        // List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的[左闭右开]区间的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);

    }
}
