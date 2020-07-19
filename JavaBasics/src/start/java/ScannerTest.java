package start.java;

/**
 * @author YunTang
 * @create 2020-07-01 19:10
 */

/*
①导包：import java.util.Scanner
②实例化：Scanner scanner = new Scanner(System.in);
③调用Scanner的相关方法，完成相关功能
 */

import java.util.Scanner;


public class ScannerTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("请输入你的姓名：");
        String name = scan.next();
        System.out.println(name);

        // 对于char型，scanner没有提供特定的方法
        System.out.println("请输入你的性别：(男/女)");
        String gender = scan.next();
        char genderChar = gender.charAt(0); // 获取字符串的第一个字符
        System.out.println(genderChar);

        System.out.println("请输入你的年龄：");
        int num = scan.nextInt();
        System.out.println(num);

        System.out.println("请输入你的体重：");
        double weight = scan.nextDouble();
        System.out.println(weight);

        System.out.println("是否中意我？(true/false)");
        boolean isLove = scan.nextBoolean();
        System.out.println(isLove);


    }
}
