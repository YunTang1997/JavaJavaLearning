package practice.java;

import java.util.HashSet;

/**
 * @author YunTang
 * @create 2020-07-25 9:53
 */

public class Offer13 {

    int m, n, k;
    boolean[][] record;

    public static void main(String[] args) {

        Offer13 offer13 = new Offer13();
        System.out.println(offer13.movingCount(38, 15, 9));
    }

    public int movingCount(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.record = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj){

        if (i >= m || j >= n || (si + sj) > k || record[i][j]){
            return 0;
        }
        record[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? (si - 8) : (si + 1), sj) +
                dfs(i, j + 1, si, (j + 1) % 10 == 0 ? (sj - 8) : (sj + 1));
    }
}
