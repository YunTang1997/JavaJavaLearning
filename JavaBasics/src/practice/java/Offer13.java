package practice.java;

/**
 * 地上有一个m行n列的方格，从坐标[0,0]到坐标[m-1,n-1]。
 * 一个机器人从坐标[0, 0]的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格[35, 37]，因为3+5+3+7=18。但它不能进入方格[35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
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
