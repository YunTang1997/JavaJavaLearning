package start.java;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author YunTang
 * @create 2020-07-10 19:54
 */

public class QuickSortTest {

    public static void main(String[] args) {

        int[] MyArray = new int[]{0, -5, 87, 45, 67, 13, 77, 23, 77, 89, -13};
        QuickSortTest test = new QuickSortTest();
        test.quickSort(MyArray, 0, MyArray.length - 1); // 快速排序

        System.out.println(Arrays.toString(MyArray)); // 输出数组
    }

    public void quickSort(int[] Array, int start, int end){
        int left = start, right = end;
        if (left >= right){
            return;
        }
        int currentValue = Array[left];
        while (left < right){
            if (left < right && Array[right] >= currentValue){
                right--;
            }
            Array[left] = Array[right];
            if (left < right && Array[left] < currentValue){
                left++;
            }
            Array[right] = Array[left];
        }
        Array[left] = currentValue;
        quickSort(Array, start, left - 1);
        quickSort(Array, left + 1, end);

    }

}
