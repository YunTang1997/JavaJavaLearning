package main.java.queue;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-08-05 21:48
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

}

// 使用数组模拟队列
class ArrayQueue {

    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数组，模拟队列

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[arrMaxSize];
        this.front = -1; // 指向队列的头部，分析出front是指向队列头的前一个位置
        this.rear = -1; // 指向队列的尾部，指向队列尾的数据（即队列最后一个数据）
    }

    // 判断队列是否为满了
    public boolean ifFull() {
        return rear == (maxSize - 1);
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int n) {

        if (ifFull()) {
            System.out.println("队列满了，不能加入数据");
            return;
        }
        rear ++; // 头部指针上移
        arr[rear] = n;
    }

    // 获取队列数据
    public int getQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取出数据");
        }
        front ++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    // 显示队列头数据（仅仅显示）
    public int headQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1]; // ++的原因是因为front指向的是队列头部的前一个位置
    }
}
