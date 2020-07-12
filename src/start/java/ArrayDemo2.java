package start.java;

import com.sun.javafx.robot.FXRobotImage;
import sun.text.normalizer.CharTrie;

/**
 * @author YunTang
 * @create 2020-07-04 20:29
 */

public class ArrayDemo2 {

    public static void main(String[] args) {

        // 打印10行的杨辉三角
        int[][] yangHui = new int[10][]; // 初始化
        for (int i = 0; i < yangHui.length; i++) {

            yangHui[i] = new int[i + 1]; // 初始化

            // 每一行首尾元素为1
            yangHui[i][0] = yangHui[i][i] = 1;

            // 非首尾元素
            if(i > 1){
                for (int j = 1; j < yangHui[i].length - 1; j++) {

                    yangHui[i][j] = yangHui[i - 1][j] + yangHui[i - 1][j - 1];

                }
            }
        }

        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {

                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");
        // 创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。同时，要求元素的值各不相同。
        int [] myArray = new int[6];
        for (int i = 0; i < myArray.length; i++) {

            myArray[i] = (int)(Math.random() * 30 + 1);

            for (int j = 0; j < i; j++) {

                if (myArray[j] == myArray[i]){
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + "\t");
        }
    }
}
