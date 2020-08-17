package main.java.tree;

/**
 * @author YunTang
 * @create 2020-08-09 20:34
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    // 重载前序遍历方法
    public void preOrder() {
        this.preOrder(0); // 根节点下标为0
    }

    // 前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
