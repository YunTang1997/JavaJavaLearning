package start.java;

import sun.management.Agent;
import sun.print.PrintJob2D;

import java.util.Objects;

/**
 * @author YunTang
 * @create 2020-07-17 22:07
 */

/*
 * 面试题： == 和 equals() 区别
 *
 * 一、回顾 == 的使用：
 * == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是[基本数据类型]变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *    如果比较的是[引用数据类型]变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 *
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于[引用数据类型]
 * 3. Object类中equals()的定义：
 *    public boolean equals(Object obj) {
	        return (this == obj);
	  }
 *    说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 *
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 *    两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 *
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 *    就需要对Object类中的equals()进行重写.
 *    重写的原则：比较两个对象的实体内容是否相同.（可以通过ctrl+insert选择生成重写的equals（）方法）
 */

public class EqualsTest {

    public static void main(String[] args){

        Animal dog1 = new Animal("狗", 2);
        Animal dog2 = new Animal("狗", 2);
        System.out.println(dog1.equals(dog2));
    }
}

class Animal{
    private String variety;
    private int age;

    public Animal(){
        super();
    }

    public Animal(String variety, int age){
        super();
        this.variety = variety;
        this.age = age;
    }

    public void setVariety(String variety){
        this.variety = variety;
    }

    public String getVariety(){
        return this.variety;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    // 从写equals方法，比较两个类的实体内容是否一致
    @Override
    public boolean equals(Object obj){ // 多态性Object obj = new ....
        if (this == obj){ // 地址一样肯定是同一个对象
            return true;
        }

        if (obj instanceof Animal){ // 判断obj是不是Animal的一个实例
            Animal a1 = (Animal)obj; // 向下强转
            // 比较两个对象的每个属性是否相同
            if(this.variety.equals(a1.variety) && this.age == a1.age){ // 注意variety是String类型，需要用equals(String重写后的)判断两者字符组成是否一致
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

}


