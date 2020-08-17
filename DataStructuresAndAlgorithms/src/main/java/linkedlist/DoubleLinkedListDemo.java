package main.java.linkedlist;

/**
 * @author YunTang
 * @create 2020-08-02 20:04
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

//        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
//        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
//        HeroNode2 node3 = new HeroNode2(3, "吴用", "智多星");
//        HeroNode2 node4 = new HeroNode2(4, "林冲", "豹子头");

        HeroNode2 node1 = new HeroNode2(4, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 node3 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 node4 = new HeroNode2(1, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node4);

        doubleLinkedList.update(new HeroNode2(4, "公孙胜", "入云龙")); // 修改节点

        doubleLinkedList.del(3);

        doubleLinkedList.list();
    }
}


// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode2 {

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 prev; // 执行前一个结点，默认为null
    public HeroNode2 next; // 执行后一个节点，默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class DoubleLinkedList {

    /*初始化头节点*/
    private HeroNode2 head = new HeroNode2(0, "", "");

    /*获得头节点*/
    public HeroNode2 getHead() {
        return head;
    }

    /*添加节点到单向链表*/
    // 思路：找到当前链表的最后一个节点；将最后一个节点的next指向添加节点，并将添加节点的prev指向最后一个节点
    public void add(HeroNode2 heroNode2) {

        // 由于头节点不能动，因此需要创建一个辅助指针temp
        HeroNode2 temp = head;
        // 找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 添加节点，形成双向链表
        temp.next = heroNode2;
        heroNode2.prev = temp;
    }

    /*遍历双向链表*/
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("此链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /*根据排名插入到指定的位置*/
    public void addByOrder(HeroNode2 heroNode2) {

        // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {

            if (temp.next == null) { // 到达链表尾部
                break;
            }
            if (temp.next.no > heroNode2.no) { // 找到了添加为位置
                break;
            } else if (temp.next.no == heroNode2.no) { // 希望添加的heroNode编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("相同的no:%d只能添加一个\n", heroNode2.no);
        } else {
            if (temp.next != null) { // 注意temp是尾结点的情况
                heroNode2.next = temp.next;
                temp.next.prev = heroNode2;
            }
            temp.next = heroNode2;
            heroNode2.prev = temp;
        }
    }

    /*修改节点的信息*/
    // 和单向链表一致
    public void update(HeroNode2 newHerNode2) {

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) { // 已遍历完链表，没找到对应的no
                break;
            }
            if (temp.no == newHerNode2.no) { // 找到需要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.nickname = newHerNode2.nickname;
            temp.name = newHerNode2.name;
            return;
        }
        System.out.printf("编号为%d的节点不存在\n", newHerNode2.no);
    }

    /*删除节点*/
    // 1.对于双向链表，我们可以直接找到要删除的这个节点
    // 2.找到后，自我删除即可
    public void del(int no) {

        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {

            if (temp == null) { // 已遍历完链表，没找到对应的no
                flag = true;
                break;
            }
            if (temp.no == no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号为%d的节点不存在\n", no);
            return;
        }
        temp.prev.next = temp.next;
        if (temp.next != null) { // 如果删除的是最后一个节点，则不用执行下面的语句
            temp.next.prev = temp.prev;
        }
    }
}