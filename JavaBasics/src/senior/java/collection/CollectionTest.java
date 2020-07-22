package senior.java.collection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author YunTang
 * @create 2020-07-21 10:25
 */

/*
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 *
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：[单列]集合，用来存储一个一个的[对象]
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：[双列]集合，用来存储一对(key - value)一对的[数据]   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *    向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */

public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        // add(Obeject e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(new String("DD"));
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // size()：获取添加元素的个数
        System.out.println(coll.size()); // 4

        //addall(Collection coll1)：将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size()); // 6
        System.out.println(coll);

        // isEmpty()：判断当前集合是否为空
        System.out.println(coll.isEmpty());

        // clear()：清空集合元素
//        coll.clear();

        // contains(Object obj)：判断当前集合中是否包含obj
        // 我们在判断时会调用obj对象所在类的[equals方法]
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("DD")));

        // containsall(Collection coll1)：判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll2 = Arrays.asList(123, 45678);
        System.out.println(coll.containsAll(coll2));

    }

    @Test
    public void test2(){

        Collection coll = new ArrayList();

        // add(Obeject e)：将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(new String("DD"));
        coll.add(123); // 自动装箱

        // remove(Object obj)：从当前集合中移除obj
        coll.remove(123);
        System.out.println(coll);

        // removeall(Collection coll1)：差集：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add("BB");
        coll.add(false);

        // retainAll(Collection coll1)：交集：获取当前集合和coll集合的交集，[并返回给当前集合]
//        Collection coll1 = Arrays.asList(123, 456, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        // equals(Object obj)：要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new String("AA"));
        coll2.add("BB");
        coll2.add(false);

        System.out.println(coll.equals(coll2));
    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add("BB");
        coll.add(false);

        // hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // 集合--->数组：：toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + "\t");
        }
        System.out.println();

        // 数组--->集合：调用Arrays类的[静态方法]asList()
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size()); // 1

        List<Integer> arr2 = Arrays.asList(123, 456);
        System.out.println(arr2.size()); // 2

        List<Integer> arr3 = Arrays.asList(new Integer(123), new Integer(456));
        System.out.println(arr3.size()); // 2

        // iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
