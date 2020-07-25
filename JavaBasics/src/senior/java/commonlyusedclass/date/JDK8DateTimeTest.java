package senior.java.commonlyusedclass.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author YunTang
 * @create 2020-07-24 19:05
 */

public class JDK8DateTimeTest {

    @Test
    public void test1(){

        // 偏移量的问题
        Date date1 = new Date(2020 - 1900, 9 - 1, 8); // 年份从1900年开始，月份从0开始
        System.out.println(date1); // Tue Sep 08 00:00:00 CST 2020
    }

    /**
     * LocalDate、LocalTime、LocalDateTime的使用
     *     说明：
     *         1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
     *         2.类似于Calendar
     */
    @Test
    public void test2(){

        //now()：获取当前的日期、时间、日期+时间（now()静态方法）
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 11, 23, 25, 3);
        System.out.println(localDateTime1);

        // getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        // 体现不可变性
        // withXxx()：设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        // 体现不可变性
        // plusXxx()：增加相关的属性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        // 体现不可变性
        // minusXxx()：减少相关的属性
        LocalDateTime localDateTime4 = localDateTime.minusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /**
     * Instant的使用：类似于java.util.Date类
     */
    @Test
    public void test3(){

        // now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2020-07-24T19:42:06.617+08:00

        // toEpochMilli()：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // ofEpochMilli()：通过给定的毫秒数，获取Instant实例  --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1595591095275L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter:格式化或解析日期、时间（类似于SimpleDateFormat）
     */
    @Test
    public void test4(){

        /*
         方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        */
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // 格式化：日期 --> 字符串
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String str = formatter.format(localDateTime1);
        System.out.println(localDateTime1);
        System.out.println(str);

        // 解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2020-07-24T19:51:45.688");
        System.out.println(parse);


        /*方式二：
            本地化相关的格式。如：ofLocalizedDateTime()
            FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        */
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        // 格式化
        String format = formatter1.format(localDateTime1);
        System.out.println(format); // 2020年7月24日 下午08时02分03秒

        // 解析
        TemporalAccessor parse1 = formatter1.parse("2020年7月24日 下午07时59分46秒");
        System.out.println(parse1);


        /*
        本地化相关的格式。如：ofLocalizedDate()
        FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        */
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        // 格式化
        String format1 = formatter2.format(LocalDate.now());
        System.out.println(format1); // 2020年7月24日


        /*
        重点：方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        */
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        // 格式化
        String format2 = formatter3.format(localDateTime1);
        System.out.println(format2); // 2020-07-24 08:04:20

        // 解析
        TemporalAccessor parse2 = formatter3.parse("2020-07-24 08:04:20");
        System.out.println(parse2); // {MicroOfSecond=0, HourOfAmPm=8, NanoOfSecond=0, SecondOfMinute=20, MilliOfSecond=0, MinuteOfHour=4},ISO resolved to 2020-07-24
    }
}
