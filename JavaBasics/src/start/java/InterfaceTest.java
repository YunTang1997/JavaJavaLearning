package start.java;

/**
 * @author YunTang
 * @create 2020-07-19 18:14
 */

/*
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.Java中，接口和类是并列的两个结构
 * 3.如何定义接口：定义接口中的成员
 *
 * 		3.1 JDK7及以前：只能[定义全局常]和[抽象方法]
 * 			>全局常量：public static final的.但是书写时，可以省略不写
 * 			>抽象方法：public abstract的
 *
 * 		3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义[静态方法]、[默认方法]
 *
 * 4. 接口中不能定义构造器的！意味着接口不可以实例化
 *
 * 5. Java开发中，接口通过让类去[实现](implements)的方式来使用.
 *    如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 *    如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 *
 * 6. Java类可以实现[多个]接口   --->弥补了Java[单继承性]的局限性
 *   格式：class AA extends BB implements CC,DD,EE（先写继承后写实现）
 *
 * 7. 接口与接口之间可以继承，而且可以[多继承]
 *
 * *******************************
 * 8. 接口的具体使用，体现多态性
 * 9. 接口，实际上可以看做是一种规范
 *
 * 面试题：抽象类与接口有哪些异同？
 *    同：抽象类和接口都不能实例化；都可以被继承
 *
 *  不同：抽象类：有构造器；java不支持类多继承；
 *       接口：不能声明构造器；java支持接口多继承；
 *
 */

public class InterfaceTest {

    public static void main(String[] args) {

        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
    }

}

interface Flyable{

    // 全局常量
    public static final int MAX_SPEED = 7900;
//    int MAX_SPEED = 7900; // public static final可省略不写

    public static final int MIN_SPEED = 1;
//    int MIN_SPEED = 7900; // public static final可省略不写

    // 抽象的方法
    public abstract void fly();
//    void fly(); // public abstract可省略不写

    public abstract void stop();
//    void stop(); // public abstract可省略不写

}

interface Attackable{

    public abstract void attact();
}

// 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

// 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类（下面还有一个stop抽象方法没有重写，所以只能将kite定义为抽象类）
abstract class kite implements Flyable{

    @Override
    public void fly() {

    }
}


class Bullet extends Object implements Flyable, Attackable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attact() {

    }
}



