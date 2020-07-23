package senior.java.map;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author YunTang
 * @create 2020-07-22 18:43
 */

public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照[key进行排序]：自然排序 、定制排序

    //自然排序
    @Test
    public void test(){
        TreeMap treeMap = new TreeMap();

        User user1 = new User("Tom", 21);
        User user2 = new User("Jerry", 23);
        User user3 = new User("Jack", 17);
        User user4 = new User("Rose", 18);
        User user5 = new User("Tony", 77);
        User user6 = new User("Lucy", 10);

        treeMap.put(user1, 98);
        treeMap.put(user2, 89);
        treeMap.put(user3, 55);
        treeMap.put(user4, 35);
        treeMap.put(user5, 34);
        treeMap.put(user6, 66);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 定制排序
    @Test
    public void test2(){

        // Comparator接口的匿名实现类的匿名对象
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge()); // 按年龄从小到大
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });

        User user1 = new User("Tom", 21);
        User user2 = new User("Jerry", 23);
        User user3 = new User("Jack", 17);
        User user4 = new User("Rose", 18);
        User user5 = new User("Tony", 77);
        User user6 = new User("Lucy", 10);

        treeMap.put(user1, 98);
        treeMap.put(user2, 89);
        treeMap.put(user3, 55);
        treeMap.put(user4, 35);
        treeMap.put(user5, 34);
        treeMap.put(user6, 66);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
