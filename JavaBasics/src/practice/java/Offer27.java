package practice.java;

import java.util.ArrayList;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * @author YunTang
 * @create 2020-08-17 9:55
 */
public class Offer27 {

    public static void main(String[] args) {

    }
    TreeNode mirrorTree_1(TreeNode root) {
        if (root == null) return null;
        TreeNode rootleft = root.left; // 注意：记录左结点，否则下一步会更改root左结点
        root.left = mirrorTree_1(root.right);
        root.right = mirrorTree_1(rootleft);
        return root;
    }

    TreeNode mirrorTree_2(TreeNode root) {
        if (root == null) return null;
        TreeNode rootleft = mirrorTree_2(root.right);
        TreeNode rootright = mirrorTree_2(root.left);
        root.left = rootleft;
        root.right = rootright;
        return root;
    }

    TreeNode mirrorTree_3(TreeNode root) {
        if (root == null) return null;
        ArrayList<TreeNode> stack = new ArrayList();
        stack.add(root);
        while(stack.size() > 0) {
            TreeNode node = stack.remove(stack.size() - 1);
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode helper = node.left;
            node.left = node.right;
            node.right = helper;
        }
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
