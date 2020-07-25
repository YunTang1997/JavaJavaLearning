package senior.java.commonlyusedclass.string;

import org.junit.jupiter.api.Test;

/**
 * @author YunTang
 * @create 2020-07-24 16:09
 */

public class StringTest2 {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length()); //4

        System.out.println(sb); //"null"

        StringBuffer sb1 = new StringBuffer(str); //源码中str.length()抛异常NullPointerException
        System.out.println(sb1); //

    }
}
