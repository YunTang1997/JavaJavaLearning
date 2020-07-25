package start.java;

/**
 * @author YunTang
 * @create 2020-07-04 14:21
 */

/*
①数组本身是引用数据类型，而数组中的元素可以是任何数据类型，包括基本数据类型和引用数据类型。
②创建数组对象会在内存中开辟一整块连续的空间，而数组名中引用的是这块连续空间的首地址。
③数组的长度一旦确定，就不能修改。

数组的使用：
    ① 数组的声明和初始化
    ② 如何调用数组的指定位置的元素
    ③ 如何获取数组的长度
    ④ 如何遍历数组
    ⑤ 数组元素的默认初始化值
    ⑥ 数组的内存解析
 */

public class ArrayTest {

    public static void main(String[] args) {

        // ① 一维数组的声明和初始化
        int[] myArrayOne; // 声明
        // 静态初始化：数组的初始化和数组的赋值同时操作
        myArrayOne = new int[]{1001, 1002, 1003, 1004}; // 初始化

        // 动态初始化数组的初始化和数组的赋值分开操作
        String[] myAarrayTwo = new String[5];

        // 注意数组一旦初始化完成其长度就已经定了


        // ② 如何调用数组的指定位置元素
        myAarrayTwo[0] = "呵呵";
        myAarrayTwo[1] = "哈哈";
        myAarrayTwo[2] = "嘻嘻";
        myAarrayTwo[3] = "哒哒";
        myAarrayTwo[4] = "呜呜";


        // ③ 如何获取数组的长度
        System.out.println(myArrayOne.length); // 4
        System.out.println(myAarrayTwo.length); // 5


        // ④ 如何遍历数组
        for (int i = 0; i < myAarrayTwo.length; i++) {
            System.out.println(myAarrayTwo[i]);
        }

        // ⑤ 数组元素的默认初始化值
        /*
        数组元素是整型：0
        数组元素是浮点型：0.0
        数组元素是char型：0或'\u0000'，而非'0'
        数组元素是boolean型：false
        数组元素是引用数据类型：null
        */

        // ⑥ 数组的内存解析


        // ① 二维数组的声明和初始化（注意特殊写法情况：int[] x, y[]; x是一维数组，y是二维数组）
        // Java中多维数组[不必都是规则矩阵形式]
        int[][] myArrayThree = new int[][]{{1, 2, 3}, {2, 4}, {5, 7}}; // 静态初始化1
        int[] myArrayThree2[] = new int[][]{{1, 2, 3}, {2, 4}, {5, 7}}; // 静态初始化2
        int[][] myArrayThree1 = {{1, 2, 3}, {2, 4}, {5, 7}}; // 类型推断（简写）

        int[][] myArrayFour = new int[3][2]; // 动态初始化1

        int[][] myArrayFive = new int[3][]; // 动态初始化2
        // int[][] myArrayFive1 = new int[][3]; // 非法
        myArrayFive[1] = new int[4]; // myArrayFive第二维大小初始化


        // ② 如何调用数组的指定位置的元素
        System.out.println(myArrayThree[0][1]);


        // ③ 如何获取数组的长度
        System.out.println(myArrayThree.length); // 3
        System.out.println(myArrayThree[0].length); // 3
        System.out.println(myArrayThree[1].length); // 2


        // ④ 如何遍历数组
        for (int i = 0; i < myArrayThree.length; i++) {

            for (int j = 0; j < myArrayThree[i].length; j++) {

                System.out.println(myArrayThree[i][j]);

            }

        }


        // 数组元素的默认初始化值
        /*
        针对于初始化方式一：比如：int[][] arr = new int[4][3];
            外层元素的初始化值为：[地址值]
            内层元素的初始化值为：与一维数组初始化情况相同
        针对于初始化方式二：比如：int[][] arr = new int[4][];
    	    外层元素的初始化值为：[null]（虽然第二维度还没有初始化，但它至少是一个一维数组，所以为null）
            内层元素的初始化值为：不能调用，否则报错。
        */

            
        // ⑥ 数组的内存解析
    }
}
