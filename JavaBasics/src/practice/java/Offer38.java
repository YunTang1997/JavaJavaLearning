package practice.java;

import org.junit.jupiter.api.Test;
import start.java.PersonTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author YunTang
 * @create 2020-07-23 14:32
 */

/*
输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Offer38 {

    char[] c;
    ArrayList<String> res= new ArrayList<>();

    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        String[] result = offer38.permutation("abc");
        System.out.println(Arrays.toString(result));
    }

    public String[] permutation(String s){
        c = s.toCharArray(); // String转化为char型数组
        dfs(0);
        return res.toArray(new String[res.size()]); // 转化为[指定类型]的数组，若不加参数直接转为Object[]数组
    }

    public void dfs(int x){
        if (x == c.length - 1){
            res.add(String.valueOf(c)); // String.valueOf()可以直接将char型数组转化为String
            return;
        }
        HashSet<Character> test = new HashSet<>(); // 用于判断x位是否重复
        for(int i = x ; i < c.length; i++){
            if (test.contains(c[i])){ // 重复减枝
                continue;
            }
            test.add(c[i]);
            swap(i, x); // 将c[i]固定于x位
            dfs(x + 1); // 固定x+1位的字母
            swap(i, x); // 交换回来
        }
    }

    public void swap(int i, int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
