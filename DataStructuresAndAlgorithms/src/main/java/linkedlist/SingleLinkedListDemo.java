package main.java.linkedlist;

/**
 * @author YunTang
 * @create 2020-08-02 15:48
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

//        HeroNode node1 = new HeroNode(4, "宋江", "及时雨");
//        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
//        HeroNode node3 = new HeroNode(2, "吴用", "智多星");
//        HeroNode node4 = new HeroNode(1, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node4);

        singleLinkedList.update(new HeroNode(2, "小卢", "管家")); // 修改节点

        singleLinkedList.del(2); // 删除节点

        singleLinkedList.list();
    }

}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向后一个节点默认为null

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class SingleLinkedList {

    // 先初始化一个头节点，头节点不能动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    /*返回头节点*/
    public HeroNode getHead() {
        return head;
    }

    /*添加节点到单向链表*/
    // 思路：找到当前链表的最后一个节点；将最后一个节点指向添加节点
    public void add(HeroNode heroNode) {

        // 由于头节点不能动，因此需要创建一个辅助指针temp
        HeroNode temp = head;
        // 找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 添加节点
        temp.next = heroNode;
    }

    /*遍历*/
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("此链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    /*根据排名插入到指定的位置*/
    public void addByOrder(HeroNode heroNode) {

        // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;
        while (true) {

            if (temp.next == null) { // 到达链表尾部
                break;
            }
            if (temp.next.no > heroNode.no) { // 找到了添加为位置
                break;
            } else if (temp.next.no == heroNode.no) { // 希望添加的heroNode编号已然存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("相同的no:%d只能添加一个\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /*修改节点的信息*/
    public void update(HeroNode newHerNode) {

        HeroNode temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) { // 已遍历完链表，没找到对应的no
                break;
            }
            if (temp.no == newHerNode.no) { // 找到需要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.nickname = newHerNode.nickname;
            temp.name = newHerNode.name;
            return;
        }
        System.out.printf("编号为%d的节点不存在\n", newHerNode.no);
    }

    /*删除节点*/
    public void del(int no) {

        HeroNode temp = head;
        boolean flag = false;
        while (true) {

            if (temp == null) { // 已遍历完链表，没找到对应的no
                flag = true;
                break;
            }
            if (temp.next.no == no) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号为%d的节点不存在\n", no);
            return;
        }
        temp.next = temp.next.next;
    }
}
