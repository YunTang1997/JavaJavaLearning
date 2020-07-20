package start.java;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Date;

/**
 * @author YunTang
 * @create 2020-07-20 19:13
 */

/*
 * 一、异常体系结构
 *
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|------编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|------运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException
 * 					|-----ArithmeticException
 *
 * 面试题：常见的异常都有哪些？举例说明
 */

public class ExceptionTest1 {

    // NullPointerException
    @Test
    public void test1(){
        String str = null;
        System.out.println(str.charAt(0));
    }

    // ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        int[] arr = new int[10];
        System.out.println(arr[10]);
    }

    // ClassCastException
    @Test
    public void test3(){
        Object obj = new Date(); // 多态
        String str = (String)obj; // 向下强转
    }

    // NumberFormatException
    @Test
    public void test4(){
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }

    // InputMismatchException
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt(); // 如果输入的不是整数则会报异常
        System.out.println(score);
        scanner.close();
    }

    // ArithmeticException
    @Test
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

}
