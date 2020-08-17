package practice.java;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @author YunTang
 * @create 2020-08-17 14:24
 */
public class Offer07 {

    public static void main(String[] args) {

    }

    HashMap<Integer, Integer> hashMap = new HashMap();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.po = preorder;
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return recursion(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param root_index: 前序遍历中根节点的索引root_index
     * @param in_left: 中序遍历左边界in_left
     * @param in_right: 中序遍历右边界in_right
     * @return
     */
    TreeNode recursion(int root_index, int in_left, int in_right) {
        if (in_left > in_right) return null; // 当in_left > in_right，子树中序遍历为空，说明已经越过叶子节点，此时返回null
        TreeNode root = new TreeNode(po[root_index]);
        int i = hashMap.get(root.val);
        // 左子树：根节点索引为root_index + 1，中序遍历的左右边界分别为in_left和i - 1。
        root.left = recursion(root_index + 1, in_left, i - 1);
        // 根节点索引为i - in_left + root_index + 1（即：根节点索引 + 左子树长度 + 1），中序遍历的左右边界分别为i + 1和in_right。
        root.right = recursion(root_index + i - in_left + 1, i + 1, in_right);
        // 返回root，含义是当前递归层级建立的根节点root为上一递归层级的根节点的左或右子节点。
        return root;
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
