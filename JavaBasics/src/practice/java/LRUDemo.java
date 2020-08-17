package practice.java;

import java.util.HashMap;

/**
 * @author YunTang
 * @create 2020-08-02 22:08
 */

public class LRUDemo {

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class Node {

    public int key;
    public int value;
    public Node prev;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private HashMap hashMap;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        hashMap = new HashMap();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (hashMap.containsKey(key)) {
            nodeMoveToTail(key);
        }
        Object res = hashMap.getOrDefault(key, -1);
        if (res instanceof Integer) {
            return ((Integer) res).intValue();
        }
        return ((Node) res).value;
    }

    public void put(int key, int value) {

        if (hashMap.containsKey(key)){
            nodeMoveToTail(key);
            Node node = (Node) hashMap.get(key);
            node.value = value;
        }
        else{
            if (hashMap.size() == capacity) {
                int unusedKey = head.next.key;
                hashMap.remove(unusedKey);
                head.next = head.next.next;
                head.next.prev = head; // 注意上一行代码中head.next指向已更新
            }
            Node newNode = new Node(key, value);
            hashMap.put(key, newNode);
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
        }
    }

    public void nodeMoveToTail(int key) {

        Node node = (Node) hashMap.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }
}

