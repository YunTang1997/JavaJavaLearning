package start.java;

/**
 * @author YunTang
 * @create 2020-07-20 16:02
 */

/*
接口在JDK8中的新特性
 */
public class JDK8NewFeaturesTest {

    public static void main(String[] args){

        JDK8NewFeature jdk8NewFeature = new JDK8NewFeature();

        // 1.接口中定义的[静态方法]，只能通过[接口]来调用
        // jdkNewFeature.method1(); // 报错
        JDK8NewFeatures.method1();

        // 2.默认方法可以通过实现类对象调用默认方法
        // 3.如果实现类重写了接口中的方法，调用时，仍然调用的是重写以后的方法
        jdk8NewFeature.method2();

        // 4.如果子类（或实现类）继承的父类和实现的接口中声明了同名通参数的方法，
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法 -->类优先原则

        // 5.如果实现类实现了多个接口，而这多个接口中定义了[同名同参数]的默认方法，
        // 那么在实现类[没有重写]此方法的情况下，报错。-->接口冲突。
        // 这就需要我们必须在实现类中[重写]此方法
        jdk8NewFeature.method3();

    }
}

class JDK8NewFeature extends JDK8NewFeatureSuperClass implements JDK8NewFeatures{

    @Override
    public void method2() {
        System.out.println("天津");
    }

    // 6.如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        method3(); // 调用自己定义的重写的方法
        super.method3(); // 调用父类的方法
        JDK8NewFeatures.super.method3(); // 调用接口中的默认方法
    }
}