package main.java.stack;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-08-08 14:14
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.showArr();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println(res);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
    }
}

class ArrayStack {

    private int maxSize;
    private int[] arr;
    private int top = -1; // top表示栈顶，初始化为-1，表示没有arr中没有元素

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int n) {
        if (isFull()) {
            System.out.println("栈空间满了，无法添加新元素");
            return;
        }
        arr[++top] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中没有元素");
        }
        return arr[top--];
    }

    public void showArr() {
        if (isEmpty()) {
            System.out.println("栈中没有数据");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d", i, arr[i]);
        }
    }
}
