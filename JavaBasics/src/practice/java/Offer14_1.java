package practice.java;

import org.junit.jupiter.api.Test;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长度的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @author YunTang
 * @create 2020-08-12 10:06
 */
public class Offer14_1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.cuttingRope1(10));
        System.out.println(solution.cuttingRope2(10));
    }
}


class Solution {
//    数学推导
    public int cuttingRope1(int n) {

        if (n > 1 && n <= 3) {
            return n - 1;
        }
        else {
            int res = n / 3;
            int m = n % 3;

            if (m == 0) {
                return (int) Math.pow(3, res);
            }
            else if (m == 1) {
                return (int) (Math.pow(3, res - 1) * 4);
            }
            else {
                return (int) ((Math.pow(3, res)) * 2);
            }
        }
    }

//    动态规划
    public int cuttingRope2(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < (n + 1); i++) {
            for (int j = 1; j < (i / 2 + 1); j++) {
                int temp = Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }
}
