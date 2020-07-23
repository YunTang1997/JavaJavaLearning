package senior.java.map;

import org.junit.jupiter.api.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * @author YunTang
 * @create 2020-07-22 10:53
 */

/*
* 一、Map的实现类的结构：
 *  |----Map:[双列]数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *         |----HashMap:作为Map的[主要实现类]；线程不安全的，效率高；存储[null]的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于[频繁的遍历]操作，此类执行效率高于HashMap。
 *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑[key]的[自然排序]或[定制排序]
 *                      底层使用[红黑树]
 *         |----Hashtable:作为古老的实现类；线程安全的，效率低；[不能]存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *
 *
 *  面试题：
 *  1. HashMap的底层实现原理？
 *  2. HashMap和Hashtable的异同？
 *  3. CurrentHashMap与Hashtable的异同？（暂时不讲）
 *
 *  二、Map结构的理解：
 *    Map中的key:无序的、不可重复的，使用[Set存储]所有的key  ---> key所在的类要重写equals()和hashCode()（以HashMap为例）
 *    Map中的value:无序的、可重复的，使用[Collection存储]所有的value --->value所在的类要重写equals()（用来判断有没有）
 *    一个键值对：key-value构成了一个[Entry对象]。
 *    Map中的entry:无序的、不可重复的，使用[Set存储]所有的entry
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明：
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了[长度是16]的一维数组Entry[] table。
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1):
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
 *      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
 *      的哈希值：
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
 *                      如果equals()返回false:此时key1-value1添加成功。----情况3
 *                      如果equals()返回true:使用value1[替换]value2。
 *
 *       补充：关于情况2和情况3：此时key1-value1和原来的数据以[链表]的方式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的[2倍]，并将原有的数据复制过来。
 *
 *      jdk8相较于jdk7在底层实现方面的不同：
 *      1. new HashMap():底层[没有]创建一个长度为16的数组
 *      2. jdk 8底层的数组是：Node[]，而非Entry[]
 *      3. 首次调用put()方法时，底层创建长度为16的数组
 *      4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *         4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
           4.2 当数组的某一个索引位置上的元素以[链表形式]存在的[数据个数 > 8]且[当前数组的长度 > 64]时，此时此索引位置上的所数据改为使用[红黑树]存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 *  四、LinkedHashMap的底层实现原理（了解）
 *      源码中：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
             Entry<K,V> before, after;//能够记录添加的元素的先后顺序
             Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
             }
         }
 *
 *
 *   五、Map中定义的方法：
 添加、删除、修改操作：
     Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     void putAll(Map m):将m中的所有key-value对存放到当前map中
     Object remove(Object key)：移除指定key的key-value对，并返回value
     void clear()：清空当前map中的所有数据
 元素查询的操作：
     Object get(Object key)：获取指定key对应的value
     boolean containsKey(Object key)：是否包含指定的key
     boolean containsValue(Object value)：是否包含指定的value
     int size()：返回map中key-value对的个数
     boolean isEmpty()：判断当前map是否为空
     boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 元视图操作的方法：
     Set keySet()：返回所有key构成的Set集合
     Collection values()：返回所有value构成的Collection集合
     Set entrySet()：返回所有key-value对构成的Set集合

 *总结：常用方法：
 * 添加：put(Object key,Object value)
 * 删除：remove(Object key)
 * 修改：put(Object key,Object value)
 * 查询：get(Object key)
 * 长度：size()
 * 遍历：keySet() / values() / entrySet()
 */

public class HashMapTest {

    @Test
    public void test1(){

        Map map = new HashMap(); // key和value中可以出现null
//        Map map = new Hashtable(); // key和value中不能出现null
        map.put(null, 123);
    }

    @Test
    public void test2(){

        // put()
        HashMap<Object, Object> map = new HashMap();

        map.put("AA", 123); // 添加
        map.put("AA", 456); // 修改（key相同时就会修改）
        map.put(123, 456);
        map.put("BB", "你好");

        System.out.println(map);

        // putAll()
        HashMap<Object, Object> map1 = new HashMap();

        map1.put("DD", 78);
        map1.put("CC", 678);

        map.putAll(map1);
        System.out.println(map);

        // remove()
        map.remove("AA");
        System.out.println(map);

        // clear()
        map.clear(); // 与map = null不同，只是删除map中的元素，map仍然存在
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void test3(){

        // get()
        HashMap<Object, Object> map = new HashMap();
        map.put("AA", 456); // 修改（key相同时就会修改）
        map.put(123, 456);
        map.put("BB", "你好");

        System.out.println(map.get("AA"));
        System.out.println(map.get(77)); // 当key在map中不存在的时候，返回null

        // containsKey()
        boolean isExist = map.containsKey("AA");
        System.out.println(isExist);
        // containsValue()
        boolean isExist1 = map.containsValue("你好");
        System.out.println(isExist1);

        // siez()
        System.out.println(map.size());

        // isEmpty()
        System.out.println(map.isEmpty());

        // equals()
        HashMap<Object, Object> map2 = new HashMap();
        map2.put("AA", 456); // 修改（key相同时就会修改）
        map2.put(123, 456);
        map2.put("BB", "你好");
        System.out.println(map.equals(map2));
    }

    @Test
    public void test4(){
        HashMap<Object, Object> map = new HashMap();
        map.put("AA", 456); // 修改（key相同时就会修改）
        map.put(123, 456);
        map.put("BB", "你好");

        System.out.println("-------------------------");
        // 遍历所有的key集：keySet()
        Set<Object> set = map.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------");
        // 遍历所有的value集：values()
        Collection<Object> values = map.values();
        for (Object obj : values){
            System.out.println(obj);
        }

        System.out.println("-------------------------");
        // 方式一
        // 遍历所有的key-value：entrySet()
        Set entries = map.entrySet();
        Iterator iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            // entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("-------------------------");
        // 方式二
        Set<Object> set1 = map.keySet();
        Iterator<Object> iterator2 = set1.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + ": " + value);
        }

    }
}
