package start.java;

/**
 * @author YunTang
 * @create 2020-07-02 16:51
 */

/*
switch(表达式){
    case 常量1:
        语句1;
        // break;
    case 常量2:
        语句2;
        // break;
    … …
    case 常量N:
        语句N;
        // break;
    default:
        语句;
        // break;
}
①break语句用来在执行完一个case分支后使程序跳出switch语句块；如果没有break，程序会顺序执行到switch结尾。
②switch(表达式)中表达式的值必须是下述几种类型之一：byte，short，char，int，枚举(jdk5.0)，String(jdk7.0)。
③case子句中的值必须是常量，不能是变量名或不确定的表达式值。
④同一个switch语句，所有case子句中的常量值互不相同。
⑤default子句是可任选的(相当于if-else中的else)。同时，位置也是灵活的。当没有匹配的case时，执行default。
⑤如果switch-case语句中有多个case执行语句相同，可以合并。
⑥如果判断的具体数值不多，而且符合byte、short 、char、int、String、枚举等几种类型。虽然两个语句都可以使用，建议使用swtich语句。因为效率稍高。
⑦其他情况：对区间判断，对结果为boolean类型判断，使用if-else，if-else的使用范围更广。也就是说，使用switch-case的，都可以改写为if-else。反之不成立。
 */

import java.util.Scanner;

public class SwitchCaseTest {

    public static void main(String[] args) {

        // 从键盘分别输入年、月、日，判断这一天是当年的第几天
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scan.nextInt();
        System.out.println("请输入月份：");
        int month = scan.nextInt();
        System.out.println("请输入号数：");
        int day = scan.nextInt();

        int sumDay = 0;
        switch (month) {
            case 12:
                sumDay += 30;
            case 11:
                sumDay += 31;
            case 10:
                sumDay += 30;
            case 9:
                sumDay += 31;
            case 8:
                sumDay += 31;
            case 7:
                sumDay += 30;
            case 6:
                sumDay += 31;
            case 5:
                sumDay += 30;
            case 4:
                sumDay += 31;
            case 3:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    sumDay += 29;
                }
                else {
                    sumDay += 28;
                }
            case 2:
                sumDay += 31;
            case 1:
                sumDay += day;
        }
        System.out.println(year + "/" + month + "/" + day + "是" + year + "年的第" + sumDay + "天");
    }
}