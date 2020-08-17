package practice.java;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @author YunTang
 * @create 2020-08-17 19:47
 */
public class Offer29 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Offer29 offer29 = new Offer29();
        System.out.println(Arrays.toString(offer29.spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        int cur = 0;
        while (true) {
            for (int i = left; i < (right + 1); i++) { // 从左至右
                res[cur] = matrix[top][i];
                cur++;
            }
            if ((++top) > bottom) break; // 更新top，并判断是否跳出循环
            for (int i = top; i < (bottom + 1); i++) { // 从上到下
                res[cur] = matrix[i][right];
                cur++;
            }
            if (left > (--right)) break; // 更新right，并判断是否跳出循环
            for (int i = right; i > (left - 1); i--) { // 从右到左
                res[cur] = matrix[bottom][i];
                cur++;
            }
            if (top > (--bottom)) break; // 更新bottom，并判断是否跳出循环
            for (int i = bottom; i > (top - 1); i--) { // 从下到上
                res[cur] = matrix[i][left];
                cur++;
            }
            if ((++left) > right) break; // 更新left，并判断是否跳出循环
        }
        return res;
    }
}
