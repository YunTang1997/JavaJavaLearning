package start.java;

/**
 * @author YunTang
 * @create 2020-07-05 10:17
 */


public class BubbleSortTest {

    public static void main(String[] args) {

        int[] myArray = new int[]{0, -5, 87, 45, 67, 13, 77, 23, 77, 89, -13};
        int arrayLen = myArray.length;
        int tmp;
        boolean mark = true;
        for (int i = 0; i < arrayLen - 1; i++) {

            for (int j = 0; j < arrayLen - 1 - i; j++) {

                if (myArray[j] > myArray[j + 1]){
                    tmp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = tmp;
                    mark = false;
                }
            }
            if (mark){
                break; // 如有一次内循环中没有进行过一次交换，说明数组此时已经有序
            }
        }
        for (int i = 0; i < arrayLen; i++) {
            System.out.print(myArray[i] + "\t");
        }
        System.out.println();
    }
}
