package start.java;

import javax.xml.transform.Source;

/**
 * @author YunTang
 * @create 2020-06-30 14:50
 */

public class OperatorTest {
    public static void main(String[] args) {

        // 除号：/
        int num1 = 12;
        int num2 = 5;
        int result1 = num1 / num2;
        System.out.println(result1); // 2

        double result2 = num1 / num2;
        System.out.println(result2); // 2.0

        double result3 = (num1 + 0.0) / num2;
        System.out.println(result3); // 2.4

        double result4 = (double)num1 / num2;
        System.out.println(result4); // 2.4

        double result5 = (double)(num1 / num2);
        System.out.println(result5); // 2.0

        // 取余（取模）：%
        // 结果的符号与被模数符号一样
        System.out.println("num1 % num2 = " + num1 % num2); // 2

        int num3 = -12;
        int num4 = 5;
        System.out.println("num3 % num4 = " + num3 % num4); // -2

        int num5 = 12;
        int num6 = -5;
        System.out.println("num5 % num6 = " + num5 % num6);// 2

        int num7= -12;
        int num8 = -5;
        System.out.println("num7 % num8= " + num7 % num8);// -2

        //前（++）、后（++）
        int a1 = 15;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ",b1 = " + b1); // 16, 16

        int a2 = 15;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + ",b2 = " + b2); // 14, 15

        byte m = 127;
        m++; // 注意：通过前（++）、后（++）、前（--）、后（--）实现自增或自减均不会改变数据类型
        System.out.println("m = " + m); // -128

        // 前（--）、后（--）
        int a3 = 15;
        int b3 = --a3;
        System.out.println("a3 = " + a3 + ",b3 = " + b3); // 14, 14

        int a4 = 15;
        int b4 = a4--;
        System.out.println("a4 = " + a4 + ",b4 = " + b4); // 14, 15

        //赋值符号：=
        //支持连续赋值
        int i1 = 10;
        int i2 = 10;
        i1= i2 = 20; // 连续赋值

        int i3 = 10, i4 = 20; // 公用类型

        short i5 = 10;
        //i5 = i5 + 1; //编译失败
        i5 += 1; // 注意不改变变量本身的数据类型（推荐使用）
        System.out.println(i5);

        int i6 = 1;
        i6 *= 0.1; // 不改变i6的数据类型
        System.out.println(i6); // 0
        i6 += 1;
        System.out.println(i6); // 1
    }
}
