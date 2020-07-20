package start.java;


/**
 * @author YunTang
 * @create 2020-07-19 16:16
 */

/*
1.抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

2.解决的问题：
①当功能内部一部分实现是确定的， 一部分实现是不确定的。这时可以把[不确定]的部分暴露出去，让[子类]去实现。
②换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，
供不同子类实现。这就是一种模板模式
 */


public class TemplateTest {

    public static void main(String[] args) {

        SubTemplate subTemplate = new SubTemplate();
        subTemplate.sepndTime();

    }
}

//  计算某段代码所花费的时间
abstract class Template{

    public void sepndTime(){

        long start = System.currentTimeMillis();

        code(); // 不确定的部分、易变部分（定义为抽象方法）

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));


    }

    public abstract void code();
}

class SubTemplate extends Template{

    @Override
    public void code() {

        for (int i = 2; i <= 1000 ; i++) {
            boolean isFlage = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {

                if (i % j == 0) {
                    isFlage = false;
                    break;
                }
            }
            if (isFlage){
                System.out.println(i);
            }
        }
    }
}

