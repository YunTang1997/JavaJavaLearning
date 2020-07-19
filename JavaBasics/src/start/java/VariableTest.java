package start.java;

/**
 * @author YunTang
 * @create 2020-06-30 9:01
 */


/*
包名：多单词组成时所有字母都小写：xxxyyyzzz
类名、接口名：多单词组成时，所有单词的首字母大写：XxxYyyZzz
变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz
常量名：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY_ZZZ
 */

/*
1.Java定义变量的格式：数据类型 变量名 = 变量值;
2.说明：
    Java中每个变量必须先声明，再赋值，后使用
    使用变量名来访问这块区域的数据
    变量的作用域：其定义所在的一对{}内
    变量只有在其作用域内才有效
    同一个作用域内，不能定义重名的变量
 */

/*
有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大（表示范围最大）的那种数据类型，然后再进行计算。
byte,short,char之间不会相互转换，他们三者在计算时首先转换为int类型。（这三种类型同类型运算也会转化为int）
boolean类型不能与其它数据类型运算。
当把任何基本数据类型的值和字符串(String)进行连接运算时(+)，基本数据类型的值将自动转化为字符串(String)类型。
 */

/*
变量类型强转：
    自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转换符：()，但可能造成精度降低或溢出,格外要注意。
    通常，字符串不能直接转换为基本类型，但通过基本类型对应的包装类则可以实现把字符串转换成基本类型。
    如： String a = “43”; int i = Integer.parseInt(a);
    boolean类型不可以转换为其它的数据类型。
 */

public class VariableTest {
    public static void main(String[] args) {
        // 变量的定义
        int myAge = 12;
        // 变量的使用
        System.out.println("myAge:" + myAge);

        // 变量的声明
        int myNumber;
        // 变量的赋值
        myNumber = 1001;
        System.out.println("myNumber:" + myNumber);

        // 整型：byte（1字节=8bit）、short（2字节）、int（4字节）、long（9字节）
        // byte范围：-128~127
        byte myByte = 12;
        System.out.println("myByte:" + myByte);

        //声明long型变量，必须以“L”或“l”结尾
        short myShort = 129;
        int myInt = 12345;
        long myLong = 127361298649L;
        System.out.println("myShort:" + myShort);
        System.out.println("myInt:" + myInt);
        System.out.println("myLong:" + myLong);

        // 浮点型：float（4个字节）、double（8个字节）
        // 浮点数表示带小数点的值
        // float表示的数值的范围比long还大
        // Java的浮点型常量默认为double型
        double myDouble = 123.3;
        // 声明float型常量，须后加“F”或“f”
        float myFloat = 12.3F;
        System.out.println("myDouble:" + myDouble);
        System.out.println("myFloat:" + myFloat);

        // 字符型：char（1字符=2字节）
        // 定义char变量，通常使用一对''，内部只能写一个字符
        char myChar = 'a';
        System.out.println("myChar" + myChar);
        char myChar1 = '\n';
        // print()不自带换行符
        System.out.print("Hello" + myChar1);
        System.out.println("World");
        // Unicode编码
        char myChar2 = '\u0043';
        System.out.println("myChar2:" + myChar2);

        //布尔型：boolean（true、false）
        boolean myBoolean = true;
        if (myBoolean){
            System.out.println("哈哈！");
        }
        else{
            System.out.println("呵呵！");
        }
    }
}
