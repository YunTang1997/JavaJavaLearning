package start.java;

/**
 * @author YunTang
 * @create 2020-07-12 19:28
 */

/*
编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长base和高height，同时声明公共方法访问私有变量。此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形的面积。
 */

public class TriAngle {
    // 属性
    private double base;
    private double height;

    // 构造器
    public TriAngle(){

    }

    public TriAngle(double b, double h){
        base = b;
        height = h;
    }

    // 方法
    public void setBase(double b){
        base = b;
    }

    public double getBase(){
        return base;
    }

    public void setHeight(double h){
        height = h;
    }

    public double getHeight(){
        return height;
    }
}
