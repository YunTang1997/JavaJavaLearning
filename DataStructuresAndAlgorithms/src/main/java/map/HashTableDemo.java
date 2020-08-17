package main.java.map;

import java.io.DataOutputStream;
import java.util.Scanner;

/**
 * 有一个公司，当有新的员工来报道时，要求将该员工的信息加入(id,性别,年龄,住址..)，当输入该员工的id时，要求查找到该员工的所有信息。
 * 要求：不使用数据库，尽量节省内存，速度越快越好=>哈希表(散列)
 * @author YunTang
 * @create 2020-08-08 16:52
 */
public class HashTableDemo {

    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("add: 添加雇员");
            System.out.println("show: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Employee emp = new Employee(id, name);
                    hashTab.add(emp);
                    break;
                case "show":
                    hashTab.showHashTab();
                    break;
                case "find":
                    System.out.println("请输入要查找的id：");
                    id = scanner.nextInt();
                    hashTab.findEmployeeById(id);
                    break;
                case "del":
                    System.out.println("请输入要删除的id：");
                    id = scanner.nextInt();
                    hashTab.delEmployeeById(id);
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
    }
}

// 创建HashTab
class HashTab {

    private EmployeeLinkedList[] employeeLinkedLists;
    private int size;

    public HashTab(int size) {
        this.size = size;
        // 初始化empLinkedListArray
        employeeLinkedLists = new EmployeeLinkedList[size];
        // 这时不要忘记分别初始化每个链表
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee) {
        // 根据员工的id,得到该员工应当添加到哪条链表
        int index = HashFun(employee.id);
        // 将employee添加到对应的链表中
        employeeLinkedLists[index].add(employee);
    }

    // 遍历所有的链表,遍历HashTab
    public void showHashTab() {
        for (int i = 0; i < size; i++) {
            employeeLinkedLists[i].showEmployee(i);
        }
    }

    // 根据id查找雇员
    public void findEmployeeById(int id) {
        int index = HashFun(id);
        Employee byId = employeeLinkedLists[index].findById(id);
        if (byId == null) {
            System.out.println("查找的雇员不存在");
        }
        else{
            System.out.printf("在第%d条链表中找到雇员id = %d\n", index + 1, id);
        }
    }

    // 根据id删除雇员
    public void delEmployeeById(int id) {
        int index = HashFun(id);
        boolean res = employeeLinkedLists[index].del(id);
        if (res) {
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }

    // 编写散列函数,使用一个简单取模法
    public int HashFun(int n) {
        return n % size;
    }
}


// 表示一个雇员
class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 创建EmployeeLinkedList
class EmployeeLinkedList {

    // 头指针，执行第一个Employee，因此这个链表的head是直接指向第一个Employee
    private Employee head;

    // 添加雇员到链表
    // 说明：假定，当添加雇员时，id是自增长，即id的分配总是从小到大，因此我们将该雇员直接加入到本链表的最后即可
    public void add(Employee employee) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = employee;
            return;
        }

        // 插在头节点前面
        if (head.id > employee.id) {
            employee.next = head;
            head = employee; // 别忘了将head拿到链表头部
            return;
        }

        // 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Employee cur = head;
        while(true) {
            if (cur.next == null) { // 找到最后一个节点
                break;
            }
            if (cur.next.id > employee.id) { // 找到合适的插入位置
                break;
            }
            cur = cur.next;
        }
        // 退出时直接将employee加入链表
        employee.next = cur.next;
        cur.next = employee;
    }

    // 通过id删除Employee
    public boolean del(int id) {
        Employee byId = findById(id);
        if (byId == null) {
            System.out.println("所要删除的对象不存在");
            return false;
        }
        Employee cur = head;
        while (true) {
            if (cur.next == byId) {
                break;
            }
            cur = cur.next;
        }
        cur.next = byId.next; // 删除节点
        return true;
    }

    // 遍历雇员信息
    public void showEmployee(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表信息为空");
            return;
        }
        Employee cur = head; // 辅助指针
        System.out.print("第" + (no + 1) + "个雇员的信息为：");
        while (true) {
            System.out.printf(" ==> id = %d, name = %S",cur.id, cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    // 根据id查找雇员
    // 如果查找到，就返回Employee, 如果没有找到，就返回null
    public Employee findById(int id) {
        if (head == null) {
            System.out.println("链表为空");
             return null;
        }
        Employee cur = head;
        while (true) {
            if (cur.id == id) { // 找到
                break; // 这时cur就指向要查找的雇员
            }
            if (cur.next == null) { // 说明遍历当前链表没有找到该雇员
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}
