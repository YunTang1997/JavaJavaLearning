package start.java;

/**
 * @author YunTang
 * @create 2020-07-04 16:10
 */

/*
从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
    成绩>=最高分-10 等级为’A’
    成绩>=最高分-20 等级为’B’
    成绩>=最高分-30 等级为’C’
    其余等级为’D’
 */

import java.util.Scanner;

public class ArrayDemo1 {

    public static void main(String[] args) {

        // 获取学生人数
        System.out.println("请输入学生人数：");
        Scanner scan = new Scanner(System.in);
        int studentNum = scan.nextInt();

        // 创建数组并存入学生成绩
        int[] studentArr = new int[studentNum];
        System.out.println("请输入学上的成绩：");
        for (int i = 0; i < studentNum; i++) {

            studentArr[i] = scan.nextInt();
        }

        int maxScore = 0;
        for (int i = 0; i < studentNum; i++) {

            maxScore = (maxScore < studentArr[i]) ? studentArr[i] : maxScore;
        }

        String scoreRank;
        for (int i = 0; i < studentNum; i++) {

            if (maxScore - studentArr[i] <= 10){

                scoreRank = "A";
            }
            else if (maxScore - studentArr[i] <=20){

                scoreRank = "B";
            }
            else if(maxScore - studentArr[i] <= 30){

                scoreRank = "C";
            }
            else{

                scoreRank = "D";
            }

            System.out.println("student" + i + " score is " + studentArr[i] + " grade is " + scoreRank);
        }

    }
}
