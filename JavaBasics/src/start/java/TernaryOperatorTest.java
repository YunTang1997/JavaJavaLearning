package start.java;

/**
 * @author YunTang
 * @create 2020-07-01 17:38
 */

/*
(条件表达式)?表达式1 : 表达式2;
说明：
①表达式的结果是boolean类型
②根据表达式的真假，决定后面运行哪一个表达式。true：运行表达式1，false：运行表达式2
③表达式1和表达式2必须要能统一到同一数据类型。例如：表达式1为int型，表达式2为string型，编译不通过
④可以嵌套使用
⑤凡是可以使用三元运算符的地方，就可以改写成if...else...，反之不成立
⑥三元运算符和if-else均可使用的场景，优先使用三算元素运算符，效率高
 */

public class TernaryOperatorTest {
    public static void main(String[] args) {

        // 获取两个的最大值
        int m = 5, n = 10;
        String max = (m > n) ? "m大" : ((m == n) ? "m等于n" : "n大");
        System.out.println(max);

        // 获取三个数的最大值
        int x = 10, y = 5, z = -6;
        int maxNew = (x >= y) ? ((x >= z) ? x : z) : ((y >= z) ? y : z);
        System.out.println(maxNew);

        int max1;
        if (x > y && x > z){
            max1 = x;
        }
        else if (y > x && y > z){
            max1 = y;
        }
        else{
            max1 = z;
        }
        System.out.println(max1);
    }
}
