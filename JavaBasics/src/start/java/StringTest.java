package start.java;

/**
 * @author YunTang
 * @create 2020-06-30 10:28
 */

/*
String不是基本数据类型，属于引用数据类型
使用方式与基本数据类型一致。例如：String str = “abcd”;
当把[任何]基本数据类型的值和字符串(String)进行连接运算时(+)，基本数据类型的值将自动转化为字符串(String)类型。
一个字符串可以串接另一个字符串，也可以直接串接其他类型的数据。例如：
    str = str + “xyz” ;
    int n = 100;
    str = str + n;
 */

public class StringTest {
    public static void main(String[] args) {

        String myString1 = "HelloWord";
        System.out.println("myString:" + myString1);

        String myString2 = "";  // String类型可以为空
        System.out.println(myString2);
        //char myChar = '';  //char类型不能为空

    }
}
