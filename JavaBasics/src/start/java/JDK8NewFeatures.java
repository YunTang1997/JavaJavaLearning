package start.java;


/**
 * @author YunTang
 * @create 2020-07-20 15:58
 */

public interface JDK8NewFeatures {

    // 静态方法
    public static void method1(){
        System.out.println("北京");
    }

    // 默认方法
    public default void method2(){
        System.out.println("上海");
    }

    default void method3(){
        System.out.println("上海");
    }
}
