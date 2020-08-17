package main.java.tree;


import javax.swing.*;
import java.util.ArrayList;

/**
 * @author YunTang
 * @create 2020-08-09 14:44
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryNode = new BinaryTree();
        for (int i = 0; i < 7; i++) {
            binaryNode.binaryTreeAdd(new Node(i + 1));
        }
        binaryNode.binaryTreePreOrder();
    }
}

class Node {
    private int value;
    private Node left; // 默认为null
    private Node right; // 默认为null

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 向二叉树中添加结点
    public void addNode(Node node) {
        ArrayList<Node> queue = new ArrayList();
        queue.add(this); // 将根结点加入队列
        while (!queue.isEmpty()) {
            Node cur = queue.remove(0);
            if (cur.left == null) {
                cur.left = node;
                return;
            }
            queue.add(cur.left);
            if (cur.right == null) {
                cur.right = node;
                return;
            }
            queue.add(cur.right);
        }
    }

    // 先序遍历
    public void preOrder() {
        // 先输出父结点
        System.out.println(this);
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void midOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        // 输出父结点
        System.out.println();
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 后续遍历
    public void postOrder() {
        // 递归向左子树中序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归向右子树中序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出父结点
        System.out.println(this);
    }

    // 前序遍历查找
    public Node preOrderSearch(int value) {
        // 比较当前结点是不是
        System.out.println("进入前序查找"); // 计数
        if (this.value == value) {
            return this;
        }
        // 1.则判断当前结点的左子节点是否为空，如果不为空，则递归前序查找
        // 2.如果左递归前序查找，找到结点，则返回
        Node res = null;
        if (this.left != null) {
            res = this.left.preOrderSearch(value);
        }
        if (res != null) { // 说明我们左子树找到
            return res;
        }
        // 1.左递归前序查找，找到结点，则返回，否继续判断，
        // 2.当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            res = this.right.preOrderSearch(value);
        }
        return res;
    }

    // 中序遍历查找
    public Node midOrderSearch(int value) {
        Node res = null;
        // 判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
        if (this.left != null) {
            res = this.left.midOrderSearch(value);
        }
        if (res != null) {
            return res;
        }
        // 和当前结点比较，如果是则返回当前结点
        System.out.println("进入中序查找"); // 计数
        if (this.value == value) {
            return this;
        }
        // 否则继续进行右递归的中序查找
        if (this.right != null) {
            res = this.right.midOrderSearch(value);
        }
        return res;
    }

    // 后续遍历查找
    public Node postOrderSearch(int value) {
        Node res = null;
        // 判断当前结点的左子节点是否为空，如果不为空，则递归后序查找
        if (this.left != null) {
            res = this.left.postOrderSearch(value);
        }
        if (res != null) { // 说明在左子树找到
            return res;
        }
        // 如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            res = this.right.postOrderSearch(value);
        }
        if (res != null) {
            return res;
        }
        // 如果左右子树都没有找到，就比较当前结点是不是
        System.out.println("进入后续查找"); // 计数
        if (this.value == value) {
            return this;
        }
        return res;
    }

    // 删除对应结点
    public void delNode(int value) {
        // 如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.left != null && this.left.value == value) {
            this.left = null;
            return;
        }
        // 如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.value == value) {
            this.right = null;
            return;
        }
        // 向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(value);
        }
        // 向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(value);
        }
    }
}

class BinaryTree {
    private Node root; // 根结点

    public void setRoot(Node node) {
        this.root = root;
    }

    // 向二叉树中添加结点
    public void binaryTreeAdd(Node node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        this.root.addNode(node);
    }

    // 前序遍历
    public void binaryTreePreOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
        else {
            System.out.println("二叉树为空");
        }
    }

    // 中序遍历
    public void binaryTreeMidOrder() {
        if (this.root != null) {
            this.root.midOrder();
        }
        else {
            System.out.println("二叉树为空");
        }
    }

    // 后续遍历
    public void binaryTreePostOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }
        else {
            System.out.println("二叉树为空");
        }
    }

    // 前序遍历查找
    public Node btPreOrderSearch(int value) {
        if (this.root != null) {
            return this.root.preOrderSearch(value);
        }
        else {
            return null;
        }
    }

    // 中序遍历查找
    public Node btMidOrderSearch(int value) {
        if (this.root != null) {
            return this.root.midOrderSearch(value);
        }
        else {
            return null;
        }
    }

    // 后续遍历查找
    public Node btPostOrderSearch(int value) {
        if (this.root != null) {
            return this.root.postOrderSearch(value);
        }
        else {
            return null;
        }
    }

    // 删除对应的结点
    // 1.如果删除的节点是叶子节点，则删除该节点
    // 2.如果删除的节点是非叶子节点，则删除该子树
    public void binaryTreeDelByValue(int value) {
        if (this.root != null) {
            if (this.root.getValue() == value) {
                this.root = null;
            } else {
                this.root.delNode(value);
            }
        }
        System.out.println("空树，不能删除！");
    }
}
