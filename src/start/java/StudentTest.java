package start.java;

import com.sun.javafx.robot.FXRobotImage;

/**
 * @author YunTang
 * @create 2020-07-07 15:07
 */

public class StudentTest {

    public static void main(String[] args){ // 程序入口

        Student[] stud = new Student[20]; // 创建Student类数组
        for (int i = 0; i < stud.length; i++){
            // 给数组元素赋值
            stud[i] = new Student();
            // 给Student类的属性赋值
            stud[i].number = i + 1;
            // 1~6年级
            stud[i].state = (int)(Math.random() * 6 + 1);
            // 分数
            stud[i].score = (int)(Math.random() * 101);
        }

        StudentTest student = new StudentTest(); // 先创建对象，利用对象调用方法
        // 遍历学生数组
        student.traver(stud);

        System.out.println("----------------------------");
        // 打印3年级的学生信息
        student.printChoice(stud, 3);

        System.out.println("----------------------------");
        // 使用冒泡排序将学生成绩排序（大到小）
        student.bubbleSort(stud);
    }

    // 方法的封装
    /**
     * 遍历学生数组
     * @param stud 学生数组数组
     */
    public void traver(Student[] stud){

        for (int i = 0; i < stud.length; i++) {
            System.out.println(stud[i].info());
        }
    }

    /**
     * 打印选择年级的学生信息
     * @param stud 学生数组
     * @param grade 选择的编辑
     */
    public void printChoice(Student[] stud, int grade){

        for (int i = 0; i < stud.length; i++) {
            if (stud[i].state == grade){
                System.out.println(stud[i].info());
            }
        }
    }

    /**
     * 使用冒泡排序将学生成绩排序（大到小）
     * @param stud 学生数组
     */
    public void bubbleSort(Student[] stud){

        Student tmp; // 创建Student类型的中间变量
        for (int i = 0; i < stud.length; i++) {
            for (int j = 0; j < stud.length - i - 1; j++) {
                if (stud[j].score < stud[j + 1].score){
                    tmp = stud[j];
                    stud[j] = stud[j + 1];
                    stud[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < stud.length; i++) {
            System.out.println(stud[i].info());
        }
    }

}
