package senior.java.commonlyusedclass.string;

import org.junit.jupiter.api.Test;


/**
 * @author YunTang
 * @create 2020-07-23 20:04
 */

/*
int length()：返回字符串的长度：return value.length

char charAt(int index)：返回某索引处的字符return value[index]

boolean isEmpty()：判断是否是空字符串：return value.length == 0

String toLowerCase()：使用默认语言环境，将String中的所有字符转换为小写

String toUpperCase()：使用默认语言环境，将String中的所有字符转换为大写

String trim()：返回字符串的副本，忽略前导空白和尾部空白

boolean equals(Object obj)：比较字符串的内容是否相同

boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写

String concat(String str)：将指定字符串连接到此字符串的结尾。等价于用“+”

int compareTo(String anotherString)：比较两个字符串的大小

String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex[开始截取到最后]的一个子字符串

String substring(int beginIndex, int endIndex)：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串


boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束

boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始

boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始


boolean contains(CharSequence s)：当且仅当此字符串包含指定的char值序列时，返回true

int indexOf(String str)：返回指定子字符串在此字符串中[第一次]出现处的索引（未找到返回-1）

int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始（未找到返回-1）

int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引

int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始[反向]搜索


替换：
String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的

String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串

String replaceAll(String regex, String replacement)：使用给定的replacement替换此字符串所有匹配给定的正则表达式的子字符串

String replaceFirst(String regex, String replacement)：使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串


匹配：
boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式


切片：
String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。

String[] split(String regex, int limit)： 根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 */

public class StringMethodsTest {

    @Test
    public void test1(){

        String s1 = "HelloWorld";
        System.out.println(s1.length());

        System.out.println(s1.charAt(0));

        String s2 = "";
        System.out.println(s2.isEmpty());

        String s3 = s1.toLowerCase();
        System.out.println(s1); // s1不可变的，仍然为原来的字符串
        System.out.println(s3); // 改成小写以后的字符串

        String s4 = "   he  ll   world";
        String s5 = s4.trim();
        System.out.println("----" + s4 + "----");
        System.out.println("----" + s5 + "----");
    }

    @Test
    public void test2(){

        String s1 = "HelloWorld";
        String s2 = "HelloWorld";
        System.out.println(s1.equals(s2));
        String s3 = "helloworld";
        System.out.println(s1.equalsIgnoreCase(s3)); // 忽略大小写

        String s4 = s1.concat("adc");
        System.out.println(s4);

        String s5 = "HelloWorlg";
        System.out.println(s1.compareTo(s5)); // 结果为负数说明s1<s5，正数说明s1=s5，0说明s1=s5

        String s6 = s1.substring(2); // 从指定索引处开始截取字串
        String s7 = s1.substring(2, 5); // 左闭右开
        System.out.println(s6);
        System.out.println(s7);
    }

    @Test
    public void test3(){

        String s1 = "HelloWorld";
        boolean b1 = s1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = s1.startsWith("He");
        System.out.println(b2);

        boolean b3 = s1.startsWith("ll", 2); // toffset表示偏移量
        System.out.println(b3);
    }

    @Test
    public void test4(){

        String s1 = "HelloWorld";
        String s2 = "Wo";
        System.out.println(s1.contains(s2));

        int i1 = s1.indexOf("Wo");
        System.out.println(i1);

        int i2 = s1.indexOf("Wo", 5); // 从指定索引开始找
        System.out.println(i2);

        int i3 = s1.lastIndexOf("or"); // 从后往前找符合条件的第一个，也就是正序的最后一个返回正序索引
        System.out.println(i3);

        int i4 = s1.lastIndexOf("or", 5); // 从指定索引处从后往前找
        System.out.println(i4);

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }

    @Test
    public void test5(){

        String s1 = "HelloWorld";
        String s2 = s1.replace('l', 'a');
        System.out.println(s2);

        String s3 = s1.replace("ll", "oo");
        System.out.println(s3);

        String s4 = "12hello34world5java7891mysql1456";
        String s5 = s4.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(s5);

        String s6 = "12345";
        boolean s7 = s6.matches("\\d+"); // 判断str字符串中是否全部有数字组成，即有1-n个数字组成
        System.out.println(s7);

        String s8 = "hello|world|java";
        String[] split = s8.split("\\|");
        for(String str : split){
            System.out.println(str);
        }
    }

    @Test
    public void test6() {

        boolean res = "abc".equalsIgnoreCase(".abc");
        System.out.println(res);
    }

}
