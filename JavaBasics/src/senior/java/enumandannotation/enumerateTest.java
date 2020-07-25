package senior.java.enumandannotation;

import java.util.Arrays;

/**
 * @author YunTang
 * @create 2020-07-25 16:04
 */

/*
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象[只有有限个]，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用[enum关键字]定义枚举类
 *
 * 三、Enum类中的常用方法：
 *    values()方法：返回枚举类型的[对象数组]。该方法可以很方便地遍历所有的枚举值。
 *    valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *    toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类[实现接口]的情况
 *   情况一：实现接口，在enum类中实现抽象方法
 *   情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class enumerateTest {

    public static void main(String[] args) {

        Season spring = Season.SPRING;
        System.out.println(spring); // Season{seasonName='春天', seasonDesc='春暖花开'}

        System.out.println("********************");
        Season1 spring1 = Season1.SPRING;
        // toString()
        System.out.println(spring1); // SPRING（当前枚举类对象常量的名称）
        System.out.println(Season1.class.getSuperclass()); // class java.lang.Enum

        System.out.println("********************");
        // values()
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values)); // [SPRING, SUMMER, AUTUMN, WINTER]

        System.out.println("********************");
        // valueOf(String objName):返回枚举类中对象名是objName的对象
        // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter); // WINTER

        System.out.println("********************");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
    }
}

// 自定义枚举类
class Season{

    // 1.声明Season对象的属性：private final修饰
    // final修饰的属性不能采用默认赋值，可以采用显式赋值、代码块赋值、构造器赋值等等
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化类的构造器，并给对象赋值属性
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供当前枚举类的多个对象：public static final修饰
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    // 4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 4.其他诉求2：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Info{
    public abstract void show();
}

/**
使用enum关键字定义枚举类
说明：定义的枚举类默认继承于java.lang.Enum类（不需要重写toString()方法）
*/
enum Season1 implements Info{

    // 1.提供当前枚举类的多个对象（必须放在前面）
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    }, // 注意是","

    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    }, // 注意是","

    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    }, // 注意是","

    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    }; // 最后是";"

    // 2.声明Season对象的属性：private final修饰
    // final修饰的属性不能采用默认赋值，可以采用显式赋值、代码块赋值、构造器赋值等等
    private final String seasonName;
    private final String seasonDesc;

    // 3.私有化类的构造器，并给对象赋值属性
    Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 情况一：实现接口，在enum类中实现抽象方法
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}


