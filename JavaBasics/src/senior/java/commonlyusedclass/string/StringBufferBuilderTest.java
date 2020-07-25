package senior.java.commonlyusedclass.string;

import org.junit.jupiter.api.Test;

import java.util.zip.DeflaterOutputStream;

/**
 * @author YunTang
 * @create 2020-07-24 10:27
 */

/*
String、StringBuffer、StringBuilder三者的异同？
    String:不可变的字符序列；底层使用final char[]存储
    StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储

    源码分析：
    String str = new String(); //char[] value = new char[0];
    String str1 = new String("abc"); //char[] value = new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16]; // 底层创建了一个[长度是16]的数组。
    System.out.println(sb1.length());
    sb1.append('a'); //value[0] = 'a';
    sb1.append('b'); //value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];

    问题1. System.out.println(sb2.length()); //3
    问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要[扩容底层]的数组。
            默认情况下，扩容为原来容量的[2倍+2]，同时将原有数组中的元素复制到新的数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)


StringBuffer的常用方法：
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end)：删除指定位置的内容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把当前字符序列逆转
    public int indexOf(String str)
    public String substring(int start,int end):返回一个从start开始到end索引结束的[左闭右开]区间的子字符串
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char ch)

    总结：
    增：append(xxx)
    删：delete(int start,int end)
    改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
    查：charAt(int n )
    插：insert(int offset, xxx)
    长度：length();
    *遍历：for() + charAt() / toString()
 */
public class StringBufferBuilderTest {

    @Test
    public void test1(){
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.setCharAt(0, 'm');
        System.out.println(stringBuffer);

        StringBuffer stringBuffer1 = new StringBuffer();
        System.out.println(stringBuffer1.length()); // 0（源码中并不是返回的value.length，而是count属性，即实际的元素个数）

    }

    @Test
    public void test2(){

        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.append(1);
        stringBuffer.append('1');
        System.out.println(stringBuffer);

//        stringBuffer.delete(2, 4); // 左闭右开"ab1"
        System.out.println(stringBuffer);

        stringBuffer.replace(3, 5, "Hello");
        System.out.println(stringBuffer);
    }

    @Test
    public void test3(){

        StringBuffer stringBuffer = new StringBuffer("abc");
//        stringBuffer.insert(2, false);
//        System.out.println(stringBuffer);

        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }

    /*
    对比String、StringBuffer、StringBuilder三者的效率：
    从高到低排列：StringBuilder > StringBuffer > String
     */
    @Test
    public void test4(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }

}
