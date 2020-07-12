package start.java;

/**
 * @author YunTang
 * @create 2020-07-02 16:09
 */

/*
假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入
一个两位数，然后按照下面的规则判定用户是否能赢。
(1)如果用户输入的数匹配彩票的实际顺序，奖金10000美元。
(2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金3000美元。
(3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1000美元。
(4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
(5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
 */

import java.util.Scanner;
import java.lang.Math;

public class IfElseTest2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两位的整数：");
        int myValue = scan.nextInt();
        int myValueGe = myValue % 10;
        int myValueShi = myValue / 10;

        // random()为产生[0.0, 1.0)的随机数，若需要产生[a, b]范围的随机数则可以使用：(int)(Math.random() * (b - a + 1) + a)
        int value = (int)(Math.random() * 90 + 10); // 注意后面一对括号不能丢
        System.out.println("彩票号码：" + value);
        int valueGe = value % 10;
        int valueShi = value / 10;

        if (myValue == value){
            System.out.println("奖金10000美元");
        }
        else if (myValueGe == valueShi && myValueShi == valueGe){
            System.out.println("奖金3000美元");
        }
        else if (myValueGe == valueGe || myValueShi == valueShi){
            System.out.println("奖金1000美元");
        }
        else if (myValueGe == valueShi || myValueShi == valueGe){
            System.out.println("奖金500美元");
        }
        else {
            System.out.println("不好意思，您没有中奖");
        }
    }
}
