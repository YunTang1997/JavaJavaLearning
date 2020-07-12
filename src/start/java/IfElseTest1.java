package start.java;

/**
 * @author YunTang
 * @create 2020-07-01 22:00
 */

/*
编写程序：由键盘输入三个整数分别存入变量num1、num2、num3，对它们进行排序(使用 if-else if-else),并且从小到大输出。
 */

/*
如果is-else中的语句只有一行，则对应的{}可以省略，但是不建议这么写
 */

import java.util.Scanner;

public class IfElseTest1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        double num1 = scan.nextDouble();
        System.out.println("请输入第二个数：");
        double num2 = scan.nextDouble();
        System.out.println("请输入第三个数：");
        double num3 = scan.nextDouble();
        if (num1 < num2){
            if (num3 < num1){
                System.out.println(num3 + "<=" + num1 + "<=" + num2);
            }
            else if (num3 > num2){
                System.out.println(num1 + "<=" + num2 + "<=" + num3);
            }
            else{
                System.out.println(num1 + "<=" + num3 + "<=" + num2);
            }
        }
        else{
            if (num3 < num2){
                System.out.println(num3 + "<=" + num2 + "<=" + num1);
            }
            else if(num3 > num1){
                System.out.println(num2 + "<=" + num1 + "<=" + num3);
            }
            else{
                System.out.println(num2 + "<=" + num3 + "<=" + num1);
            }
        }
    }

}
