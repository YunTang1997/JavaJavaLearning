package start.java;

import org.junit.jupiter.api.Test;

/**
 * @author YunTang
 * @create 2020-07-18 15:48
 */

public class WrapperInterviewTest {

    @Test
    public void test1(){
        Object o1 = true ? new Integer(1) : new Double(2.0); // 三元运算符后面两个表达式的数据类型必须一致，否者系统会自动转型（能转型的情况下）
        System.out.println(o1); // 1.0
    }

    @Test
    public void test2(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false

        //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
        //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
        // -128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率。
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true
        Integer x = 128; // 128超过了Integer的value属性的范围，相当于重新new了Integer对象
        Integer y = 128;
        System.out.println(x == y); // false
    }
}
