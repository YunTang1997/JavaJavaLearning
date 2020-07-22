package start.java;

import java.util.Scanner;

/**
 * @author YunTang
 * @create 2020-07-21 9:32
 */

/*
编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。
对数据类型不一致(NumberFormatException)、 缺少命令行参数(ArrayIndexOutOfBoundsException)、
除0(ArithmeticException)及输入负数(EcDef自定义的异常)进行异常处理。
提示：
(1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。
(2)在main()方法中使用异常处理语句进行异常处理。
(3)在程序中，自定义对应输入负数的异常类(EcDef)。
(4)运行时接受参数java EcmDef 20 10 //args[0]=“20” args[1]=“10”
(5)Interger类的static方法parseInt(String s)将s转换成对应的int值。
如：int a=Interger.parseInt(“314”); //a=314;
 */
public class EcmDef {

    // 在main()方法中使用异常处理语句进行异常处理
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            EcmDef ecmDef = new EcmDef();
            ecmDef.ecm(a, b);
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }
        catch (ArithmeticException e){
            System.out.println("除数为0");
        }
        catch (EcDef e){
            System.out.println(e.getMessage());
        }

    }

    // 在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能
    public void ecm(int a, int b) throws EcDef {
        if (a < 0 || b < 0){
            throw new EcDef("分子分母为负数");
        }
        System.out.println(a / b);
    }
}

// 在程序中，自定义对应输入负数的异常类(EcDef)
class EcDef extends Exception{

    static final long serialVersionID = -7034897133246939L;

    public EcDef(){

    }

    public EcDef(String message){
        super(message);
    }
}
