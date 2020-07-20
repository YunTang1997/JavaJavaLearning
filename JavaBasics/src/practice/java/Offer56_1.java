package practice.java;

import java.util.Arrays;

/**
 * @author YunTang
 * @create 2020-07-12 15:09
 */

/*
一个整型数组nums里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */

public class Offer56_1 {
    public static void main(String[] args) {
        Offer56_1 test = new Offer56_1(); // 创建对象

        System.out.println(Arrays.toString(test.singleNumbers(new int[]{4, 1, 4, 6})));
        System.out.println(Arrays.toString(test.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

    public int[] singleNumbers(int[] args){
        int yiHUOALL = 0;
        for(int i : args){
            yiHUOALL ^= i;
        }
        int mask = 1;
        while((mask & yiHUOALL) == 0){
            mask <<= 1;
        }
        int a = 0, b = 0;
        for(int i : args){
            if ((mask & i) == 0){
                a ^= i;
            }
            else{
                b ^= i;
            }
        }
        int [] res = new int[]{a, b};
        return res;
    }
}
