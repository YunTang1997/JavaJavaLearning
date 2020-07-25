package senior.java.commonlyusedclass.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author YunTang
 * @create 2020-07-24 15:24
 */

/*
JDK8[之前]日期和时间的API测试

1.System类中currentTimeMillis();


2.java.util.Date类
           |---java.sql.Date类

    ①两个[构造器]的使用
        >构造器一：Date()：创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象
    ②两个[方法]的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    ③java.sql.Date对应着[数据库]中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象

3.SimpleDateFormat

4.Calendar
 */
public class DateTimeTest {

    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2(){
        // 构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1); // Fri Jul 24 15:30:59 CST 2020（实际上调用了toString()方法）
        System.out.println(date1.toString());
        System.out.println(date1.getTime()); // 1595575987455

        // 构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1595575987455L);
        System.out.println(date2.toString());
    }

    @Test
    public void test3(){
        java.sql.Date date1 = new java.sql.Date(1595575987455L);
        System.out.println(date1.toString()); // 2020-07-24

        // 如何将java.util.Date对象转换为java.sql.Date对象
        // 情况一
        Date date2 = new java.sql.Date(1595575987455L); // 多态
        java.sql.Date date3 = (java.sql.Date)date2; // 向下强转

        // 情况二
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime()); // 两者的桥梁就是毫秒数
        System.out.println(date5);

        // 如何将java.sql.Date对象转换为java.util.Date对象(多态)
    }


    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     *1.两个操作：
     *  1.1 格式化：日期 --->字符串
     *  1.2 解析：格式化的逆过程，字符串 ---> 日期
     *
     *2.SimpleDateFormat的实例化
     */
    @Test
    public void test4() throws ParseException { // 抛出ParseException异常是防止所给的日期字符串格式不符合SimpleDateFormat的要求

        // 实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat();

        // 格式化日期：日期 --->字符串
        Date date1 = new Date();
        String format1 = sdf1.format(date1);
        System.out.println(format1);

        // 解析：格式化的逆过程，字符串 ---> 日期
        String str1 = "20-7-24 下午4:29";
        Date parse1 = sdf1.parse(str1);
        System.out.println(parse1);

        System.out.println("*******************");

//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 按指定的格式格式化date

        // 格式化
        String format2 = sdf2.format(date1);
        System.out.println(format2);

        // 解析：要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)，否则，抛异常
        Date parse2 = sdf2.parse("2020-07-24 04:39:40");
        System.out.println(parse2);

    }

    /**
     * 练习一：字符串"2020-09-08"转换为java.sql.Date
     *
     * 练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
     *
     *     举例：2020-09-08 ？ 总天数
     *
     *     总天数 % 5 == 1,2,3 : 打渔
     *     总天数 % 5 == 4,0 : 晒网
     *
     *     总天数的计算？
     *     方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1（加1的原因是因为int型/int型，结果会会删除小数点部分）
     *     方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
     */
    @Test
    public void test5() throws ParseException {

        // 练习一：字符串"2020-09-08"转换为java.sql.Date
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = sdf1.parse("2020-09-08"); // java.util.Date
        java.sql.Date date1 = new java.sql.Date(parse1.getTime());
        System.out.println(date1);
    }

    /**
     * Calendar日历类(抽象类）的使用
     */
    @Test
    public void test6(){

        // 实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // class java.util.GregorianCalendar

        //2.常用方法
        //get()
        int days1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days1);
        int days2 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(days2);

        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 22); // 直接更改了Calendar.DAY_OF_MONTH
        int days3 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days3);

        // add()
        calendar.add(Calendar.DAY_OF_MONTH, 3); // 若amount为负数，则为在原来的基础上减几天
        int days4 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days4);

        // getTime()：日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        // setTime()：Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        int days5 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days5);
    }

}
