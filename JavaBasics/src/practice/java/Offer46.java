package practice.java;

import java.sql.SQLOutput;

/**
 * @author YunTang
 * @create 2020-07-24 10:03
 */

/*
给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”，1翻译成“b”，……，11翻译成“l”，……，25翻译成“z”。一个数字可能有多个翻译。
请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Offer46 {

    public static void main(String[] args) {

        System.out.println(Offer46.translateNum(12258));
        System.out.println(Offer46.translateNum(1));
    }

    public static int translateNum(int num){

        String s = String.valueOf(num);
        if (s.length() == 1){
            return 1;
        }
        char[] tmp = s.toCharArray();
        int[] c = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            c[i] = Integer.parseInt(String.valueOf(tmp[i]));
        }
        int[] dp = new int[c.length];
        dp[0] = 1;
        for (int i = 1; i < c.length; i++) {
            if (i == 1 && (c[i - 1] * 10 + c[i]) <= 25){
                dp[i] = 2;
            }
            else if (c[i - 1] != 0 && (c[i - 1] * 10 + c[i]) <= 25){
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[c.length - 1];
    }
}


