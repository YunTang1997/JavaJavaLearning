package senior.java.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author YunTang
 * @create 2020-07-22 19:52
 */

/*
1.Collections:操作Collection、Map的工具类。

2.面试题：Collection和Collections的区别？
  答：Collection是一个接口，而Collections是一个工具类。

3.reverse(List)：反转List中元素的顺序

4.shuffle(List)：对List集合元素进行随机排序

5.sort(List)：根据元素的自然顺序对指定List集合元素按升序排序

6.sort(List，Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序

7.swap(List，int， int)：将指定list集合中的i处元素和j处元素进行交换

8.Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素

9.Object max(Collection，Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素

10.Object min(Collection)

11.Object min(Collection，Comparator)

12.int frequency(Collection，Object)：返回指定集合中指定元素的出现次数

13.void copy(List dest,List src)：将src中的内容复制到dest中

14.boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List对象的所有旧值
 */

public class CollectionsTest {

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        //正确的：
        List dest = Arrays.asList(new Object[list.size()]);

        System.out.println(dest.size()); //list.size();
        Collections.copy(dest, list);
        System.out.println(dest);


        /*
        Collections 类中提供了多个synchronizedXxx()方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题

         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);
    }
}
