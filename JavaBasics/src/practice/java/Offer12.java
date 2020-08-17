package practice.java;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * @author YunTang
 * @create 2020-08-17 15:53
 */
public class Offer12 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        char[] charWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, charWord, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // ①行或列索引越界或②当前矩阵元素与目标字符不同或③当前矩阵元素已访问过（③可合并至②）。
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        // 字符串word已全部匹配，即k = len(word) - 1
        if (k == (word.length - 1)) return true;
        char tmp = board[i][j];
        board[i][j] = '/'; //  将board[i][j]值暂存于变量tmp，并修改为字符'/'，代表此元素已访问过，防止之后搜索时重复访问。
        // 朝当前元素的下、上、右、左四个方向开启下层递归，使用或连接（代表只需一条可行路径），并记录结果至res。
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;  // 将tmp暂存值还原至board[i][j]元素。
        return res;
    }
}
