package practice.java;

/**输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)，B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @author YunTang
 * @create 2020-08-17 9:34
 */
public class Offer26 {

    public static void main(String[] args) {

    }

    boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false; // 如果B、A数为空则返回false
        if (A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right)) {
            return true;
        }
        // 树B是树A左子树的子结构或者树B是树A右子树的子结构
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true; // root2为null说明B树匹配完毕且与A树子结构匹配成功，返回true
        if (root1 == null) return false; // root1为null说明A树匹配完毕但并没有与B树匹配成功，返回false
        if (root1.val == root2.val) { // 递归匹配root1与root2的左右子树
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        }
        else return false; // 其余情况返回false
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
