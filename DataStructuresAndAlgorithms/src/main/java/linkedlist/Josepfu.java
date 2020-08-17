package main.java.linkedlist;

import java.beans.beancontext.BeanContext;
import java.util.concurrent.BrokenBarrierException;

/**
 * @author YunTang
 * @create 2020-08-08 9:42
 */
public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.Josepfu(5, 3, 3);
        circleSingleLinkedList.Josepfu(1, 1, 1);
    }
}

class CircleSingleLinkedList {

    private Node first = null; // 头节点不能动

    public void addNode(int num) {
        if (num < 1) {
            System.out.println("num的值不正确");
            return;
        }
        Node cur = null;
        // 构建环装单链表
        for (int i = 1; i <= num; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.setNext(first);
                cur = first;
                continue;
            }
            cur.setNext(node);
            node.setNext(first);
            cur = node;
        }
    }

    public void showNode() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = first;
        while (true) {
            System.out.println(cur.getValue());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     *
     * @param total: 总人数
     * @param n: 从第几个位置开始
     * @param m: 数到几被淘汰
     */
    public void Josepfu(int total, int n, int m) {

        addNode(total); // 创建相应人数的环形单链表

        if (n > total || n < 1) {
            System.out.println("输入的参数有误");
            return;
        }
        if (total == 1) { // 只有一个节点
            System.out.println(first.getValue());
            return;
        }
        Node cur = first;
        Node helper = null;  // 辅助指针, 永远指向first的前一个节点
        while(true) { // 找到起始位置
            if (cur.getNext().getValue() == n) {
                helper = cur; // 永远指向first的前一个节点
                first = helper.getNext();
                break;
            }
            cur = cur.getNext();
        }
        while(true) {
            if (helper == first){ // 此时只剩一个节点
                break;
            }
            for (int i = 0; i < m - 1; i++) { // 数m个数
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.print(first.getValue() + "\t"); // 输出数到m的节点的值

            // 去掉删除的节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first.getValue()); // 输出最后一个节点的值
    }
}

class Node {
    private int value;
    private Node next;

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
}

