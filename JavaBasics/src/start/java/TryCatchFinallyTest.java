package start.java;

import org.junit.jupiter.api.Test;

/**
 * @author YunTang
 * @create 2020-07-20 19:53
 */

/*
 * 一、异常的处理：抓抛模型
 *
 * 过程一："抛"：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。
 *           并将此对象抛出。
 *           一旦抛出对象以后，其后的代码就不再执行。
 *
 * 		关于异常对象的产生：① 系统自动生成的异常对象
 * 					     ② 手动的生成一个异常对象，并抛出（throw）
 *
 * 过程二："抓"：可以理解为异常的处理方式：① try-catch-finally  ② throws
 *
 *
 * 二、try-catch-finally的使用
 *
 * try{
 * 		//可能出现异常的代码
 *
 * }catch(异常类型1 变量名1){
 * 		//处理异常的方式1
 * }catch(异常类型2 变量名2){
 * 		//处理异常的方式2
 * }catch(异常类型3 变量名3){
 * 		//处理异常的方式3
 * }
 * ....
 * finally{
 * 		//一定会执行的代码
 * }
 *
 * 说明：
 * 1. finally是可选的。
 * 2. 使用try将可能出现异常代码包装起来，在执行过程中，[一旦出现异常，就会生成一个对应异常类的对象]，根据此对象
 *    的类型，去catch中进行匹配。
 *
 * 3. 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就[跳出]当前的
 *    try-catch结构（在没有写finally的情况）。继续执行其后的代码
 *
 * 4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。
 *    catch中的异常类型如果[满足子父类关系]，则要求[子类]一定声明[在父类的上面]。否则，报错
 *
 * 5. 常用的异常对象处理的方式：① String getMessage()  ② printStackTrace()
 *
 * 6. 在try结构中声明的变量，再出了try结构以后，就不能再被调用
 *
 * 7. try-catch-finally结构可以嵌套
 *
 * 体会1：使用try-catch-finally处理编译时异常，是得程序在[编译时]就不再报错，但是[运行时]仍可能报错。
 *     相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
 *
 * 体会2：开发中，由于运行时异常比较常见，所以我们通常就[不针对运行时]异常编写try-catch-finally了。
 *      针对于[编译时异常]，我们说[一定]要考虑异常的处理。
 *
 *
 * 8. try-catch-finally中finally的使用：
 *
 *    ①finally是可选的
 *
 *    ②finally中声明的是[一定]会被执行的代码。即使catch中又出现异常了，try中有return语句，catch中有
 *      return语句等情况。
 *
 *    ③像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的
 *      释放。此时的资源释放，就需要声明在finally中。
 */

public class TryCatchFinallyTest {

    @Test
    public void test1(){

        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("-------------1--------------");
        }
        catch (NullPointerException e){
            System.out.println("空指针异常");
            System.out.println("-------------2--------------");
        }
        catch (NumberFormatException e){
//            System.out.println("出现数值转换异常");
//            String getMessage();
            System.out.println(e.getMessage());

//            printStackTrace();
//            e.printStackTrace();
            System.out.println("-------------2--------------");
        }
    }

    @Test
    public void test2(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("完成");
        }
    }

    @Test
    public void methodTest(){
        int num = method();
        System.out.println(num);
    }

    public int method(){
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 1;
        }
        catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }
        finally {
            System.out.println("一定被执行");
            return 3;
        }
    }
}
