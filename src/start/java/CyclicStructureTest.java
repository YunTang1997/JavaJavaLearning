package start.java;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-07-02 20:27
 */

/*
循环语句的四个组成部分：
①初始化部分
②循环条件部分
③循环体部分
④迭代部分

for循环：
    for (①初始化部分; ②循环条件部分; ④迭代部分){
        ③循环体部分;
    }


while循环：
    ①初始化部分
    while(②循环条件部分){
    ③循环体部分;
    ④迭代部分;
    }


do while循环：
    ①初始化部分;
    do{
        ③循环体部分
        ④迭代部分
    }while(②循环条件部分);

注意：do-while循环至少执行一次循环体。

最简单“无限” 循环格式：while(true) , for(;;)。

跳出循环条件：
    ①循环条件返回false
    ②循环体中执行break
 */

import java.util.Scanner;

public class CyclicStructureTest {

    public static void main(String[] args) {
        /*
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Hello");
        }

        System.out.println("-----------------------");
        int i = 0;
        for (System.out.println('a'); i < 3; System.out.println('c'), i++) {
            System.out.println('b');
        }

        System.out.println("-----------------------");
        // 编写程序从1循环到150，并在每行打印一个值，另外在每个3的倍数行
        // 上打印出“foo”,在每个5的倍数行上打印“biz”,在每个7的倍数行上打印
        // 输出“baz”。
        for (int j = 1; j <= 150; j++) {
            System.out.print(j + " ");
            // 注意以下的全是单独的if所以都会单独的判断
            if (j % 3 == 0){
                System.out.print("foo ");
            }
            if (j % 5 == 0){
                System.out.print("biz ");
            }
            if (j % 7 == 0){
                System.out.print("baz ");
            }
            // 换行
            System.out.println();
        }

        System.out.println("-----------------------");
        // 输入两个正整数m和n，求其最大公约数和最小公倍数。
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个正整数m：");
        int m = scan.nextInt();
        System.out.println("请输入第二个正整数n：");
        int n = scan.nextInt();

        int minValue = (m <= n) ? m : n, GreatestCommonFactor = 0;
        for (int j = minValue; j > 0; j--) {
            if (m % j == 0 && n % j == 0){
                GreatestCommonFactor  = j;
                break;
            }
        }
        int LeastCommonMultiple = m * n / GreatestCommonFactor;
        System.out.println(m + "和" + n + "的最大公因数为：" + GreatestCommonFactor + "，最小公倍数为：" + LeastCommonMultiple);
        */

        // 打印如下的图形：菱形
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入需要的打印的行数（奇数）：");
        int rowNumber = scan.nextInt();
        int top = rowNumber - rowNumber / 2; // 上半部分行数
        int bottom = rowNumber / 2; // 下半部分行数
        // 打印上半层
        for (int i = 1; i <= top ; i++) {
            for (int j = 1; j <= top - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(); // 换行
        }
        
        // 打印下半层
        for (int i = 1; i <= bottom; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= bottom - i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println(); // 换行
        }

        System.out.println("-----------------------");
        // 九九乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (j * i) + '\t');
            }
            System.out.println(); // 换行
        }

        System.out.println("-----------------------");
        long start = System.currentTimeMillis(); // 当前时间毫秒数
        // 100以内的全部质数
        boolean mark; // 标记
        for (int i = 2; i < 100000; i++) {
            mark = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                // i是质数就是true否则为false
                if (i % j == 0){
                    mark = false;
                    break; // 优化一
                }
            }
            System.out.print((mark) ? (i + "\t") : "");
        }
        System.out.println(); // 换行

        long end = System.currentTimeMillis();
        System.out.println("所花费时间：" + (end - start));

        System.out.println("-----------------------");
        label:for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 10; j++){

                if(j % 4 == 0){
                    // break; // 默认跳出包裹此关键字的最近一层循环
                    // continue; // 跳过包裹此关键字的最近的循环结构的当次循环

                    // break label; // 结束指定的一层循环结构
                    continue label; // 结束指定标识的一层循环结构的当次循环
                }
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
