package start.java;

/**
 * @author YunTang
 * @create 2020-07-11 8:51
 */

/*
方法的重载（overload）  loading...
①定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。

②"两同一不同":同一个类、相同方法名
           参数列表不同：参数个数不同，参数类型不同

③判断是否是重载：跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！

④在通过对象调用方法时，如何确定某一个指定的方法：方法名 ---> 参数列表
 */

public class OverLoadTest {

    // 如下三个方法构成重载
    public void mOL(int i){

        System.out.println(i * i);
    }

    public void mOL(int i, int j){

        System.out.println(i * j);
    }

    public void mOL(String s){

        System.out.println(s);
    }

}
