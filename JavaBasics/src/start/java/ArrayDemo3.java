package start.java;

import sun.security.util.Length;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-07-05 8:53
 */


public class ArrayDemo3 {

    public static void main(String[] args) {

        // 数组的复制、反转、查找（线性查找、二分法查找）
        String[] myArray1 = new String[]{"GG", "MM", "DD", "HH", "AA", "PP"};

        // 数组的复制
        String[] myArray2 = new String[myArray1.length];
        for (int i = 0; i < myArray1.length; i++) {
            myArray2[i] = myArray1[i];
        }

        // 数组的反转（方法一）
        String tmp1;
        for (int i = 0; i < myArray1.length / 2; i++) {

            tmp1 = myArray1[i];
            myArray1[i] = myArray1[myArray1.length - 1 - i];
            myArray1[myArray1.length - 1 - i] = tmp1;
        }
        for (int i = 0; i < myArray1.length; i++) {
            System.out.print(myArray1[i] + "\t");
        }
        System.out.println();

        // 数组的反转（方法二）
        String tmp2;
        for (int i = 0, j = myArray1.length - 1; i < j; i++, j--) {

            tmp2 = myArray1[i];
            myArray1[i] = myArray1[j];
            myArray1[j] = tmp2;
        }

        System.out.println("---------------------");

        // 数组查找
        // 二分查找
        System.out.println("请输入需要查找的整数：");
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();

        int[] myArray3 = new int[]{-10, 0, 9, 35, 47, 65, 67, 73, 89, 100};
        int start = 0, end = myArray3.length - 1;
        for (int i = 0; i < myArray3.length; i++) {

            int tmp = myArray3[(start + end) / 2];

            if (tmp > target){
                end = (start + end) / 2 - 1;
            }
            else if (tmp < target){
                start = (start + end) / 2 + 1;
            }
            else {
                System.out.println("查找找的数存在且它在数组中的下标为：" + (start + end) / 2);
                break;
            }
        }
        System.out.println("你所查找的数在数组中不存在");

    }
}
