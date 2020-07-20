package start.java;


/**
 * @author YunTang
 * @create 2020-07-19 10:37
 */

public class SingletonTest2 {

    public static void main(String[] args) {

        Circle circle1 = Circle.getCircle();
        Circle circle2 = Circle.getCircle();
        System.out.println(circle1 == circle2);
    }
}

// 懒汉式
class Circle{

    // 1.私有化构造器
    private Circle(){

    }

    // 2.声明当前类对象，没有初始化
    // 4.此对象也必须声明为static
    private static Circle circle = null;


    // 3.申明public、static的返回当前类对象的方法
    public static Circle getCircle(){
        if (circle == null){
            circle = new Circle();
        }
        return circle;
    }
}

