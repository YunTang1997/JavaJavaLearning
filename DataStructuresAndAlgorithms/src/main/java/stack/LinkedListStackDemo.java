package main.java.stack;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-08-08 15:12
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {

        LinkedListStack linkedListStack = new LinkedListStack();
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
                    linkedListStack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    linkedListStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = linkedListStack.pop();
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


class Node {
    private int value;
    private Node next;
    private Node prev;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class LinkedListStack {

    private Node first = new Node(-1);
    private Node rear = first;

    public boolean isEmpty() {
        return first.getNext() == null;
    }

    public void push(int n) {
        while(true) {
            if (rear.getNext() == null) {
                break;
            }
            rear = rear.getNext();
        }
        Node node = new Node(n);

        rear.setNext(node);
        node.setPrev(rear);
        node.setNext(null);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        while (true) {
            if (rear.getNext() == null) {
                break;
            }
            rear = rear.getNext();
        }
        int value = rear.getValue();

        Node rearPrev = rear.getPrev();
        rearPrev.setNext(null);
        rear = rearPrev;
        return value;
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return;
        }
        while (true) {
            if (rear.getNext() == null) {
                break;
            }
            rear = rear.getNext();
        }
        while(true) {
            if (rear == first) {
                break;
            }
            System.out.println(rear.getValue());
            rear = rear.getPrev();
        }
    }
}
