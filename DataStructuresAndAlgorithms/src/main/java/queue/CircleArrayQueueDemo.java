package main.java.queue;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-08-06 21:06
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue queue = new CircleArrayQueue(4); // 说明设置4, 其队列的有效数据最大是3
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

class CircleArrayQueue {

    private int maxSize; // 表示数组的最大容量
    //front 变量的含义做一个调整： front就指向队列的第一个元素, 也就是说arr[front]就是队列的第一个元素
    //front 的初始值 = 0
    private int front;
    //rear 变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置。因为希望空出一个空间（注意这个空间是动态变化的）做为约定。
    //rear 的初始值 = 0
    private int rear;
    private int[] arr; // 该数据用于存放数组，模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[arrMaxSize];
    }

    // 判断队列是否已满
    public boolean isFull() {
        return ((rear + 1) % maxSize) == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法添加新元素");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的元素
    public int getQueue() {
        if (isEmpty()) {
            throw  new RuntimeException("队列为空，不能获取数据");
        }
        // 这里需要分析出front是指向队列的第一个元素
        // 1. 先把front对应的值保留到一个临时变量
        // 2. 将front后移, 考虑取模
        // 3. 将临时保存的变量返回
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 遍历
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 显示队列头数据（仅仅显示）
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front]; // 因为front指向的是队列的第一个元素
    }
}

