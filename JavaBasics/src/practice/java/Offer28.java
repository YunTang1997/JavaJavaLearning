package practice.java;


/**请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * @author YunTang
 * @create 2020-08-17 10:20
 */
public class Offer28 {

    public static void main(String[] args) {

    }

    boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true; // 当L和R同时越过叶节点：此树从顶至底的节点都对称，因此返回true
        // 当L或R中只有一个越过叶节点：此树不对称，因此返回false
        // 当结点L值 != 结点R值：此树不对称，因此返回false
        if (L == null || R == null || L.val != R.val) return false;
        // 判断两节点L.left和R.right是否对称；判断两节点L.right和R.left是否对称
        return recur(L.left, R.right) && recur(L.right, R.left);
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
