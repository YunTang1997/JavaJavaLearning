package start.java;

/**
 * @author YunTang
 * @create 2020-07-01 15:20
 */

public class LogicTest {
    public static void main(String[] args) {

        // 区分逻辑与（&）与短路与（&&），优先使用&&
        // 相同点1：&和&&运算结果相同
        // 相同点2：当符号左边是true时，二者都会执行符号右边的计算
        // 不同点：当符号左边为false时，&继续执行符号右边的运算，&&不在执行符号右边的运算
        boolean a1 = false;
        int m1 = 10;
        // 不具备短路效果
        if (a1 & (m1++) > 0){
            System.out.println("我在北京！");
        }
        else{
            System.out.println("我在南京！");
        }
        System.out.println("m1 = " + m1); // 11

        boolean a2 = false;
        int m2 = 10;
        // 具有短路效果
        if (a2 && (m2++) > 0){
            System.out.println("我在北京！");
        }
        else{
            System.out.println("我在南京！");
        }
        System.out.println("m2 = " + m2); // 10


        // 逻辑或（|）与短路或（||），优先使用||
        // 相同点1：|和||运算结果相同
        // 相同点2：当符号左边是false时，二者都会执行符号右边的计算
        // 不同点：当符号左边为true时，&继续执行符号右边的运算，&&不在执行符号右边的运算
        boolean a3 = true;
        int m3 = 10;
        // 不具备短路效果
        if (a3 | (m3++) > 0){
            System.out.println("我在北京！");
        }
        else{
            System.out.println("我在南京！");
        }
        System.out.println("m3 = " + m3); // 11

        boolean a4 = true;
        int m4 = 10;
        // 具备短路效果
        if (a4 || (m4++) > 0){
            System.out.println("我在北京！");
        }
        else{
            System.out.println("我在南京！");
        }
        System.out.println("m4 = " + m4); // 10

        boolean x = true;
        boolean y = false;
        short z = 42;
        // 注意右边的是赋值
        if ((z++ == 42) && (y = true)) z++;
        // 注意左边的是赋值
        if ((x = false) || (++z == 45)) z++;
        System.out.println("z = " + z); // 46

    }
}
