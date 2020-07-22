package senior.java.collection.set;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author YunTang
 * @create 2020-07-21 21:06
 */

public class TreeSetTest {

    @Test
    public void test1(){

        /*
        1.向TreeSet中添加的数据，要求是[相同类]的对象。
        2.两种排序方式：自然排序（实现Comparable接口）和定制排序（Comparator）
        3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
        4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
        */

        TreeSet set = new TreeSet();
        // 不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new String("Tom"));

        set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){

        TreeSet set = new TreeSet();
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test3(){

        //按照年龄从小到大排列
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(comparator); // 注意有参数
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
