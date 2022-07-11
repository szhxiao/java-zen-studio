/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Arrays;

/**
 * 数组复制
 */
public class ArrayCopyTest {
    public static void main(String[] args) {
        // 数组声明与静态初始化
        int[] nums = {1, 3, 4, 6, 7, 9};
        int[] arr;
        int[] arrCopy;

        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[" + i + "]=" + nums[i] + "\t");
        }
        System.out.println();

        // 将数组nums的地址赋给arr
        arr = nums;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = i;
            }
        }
        System.out.println("更改数组arr后的nums数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[" + i + "]=" + nums[i] + "\t");
        }
        System.out.println();

        // 复制操作
        arrCopy = Arrays.copyOf(nums, 10);
        for (int i = 5; i < arrCopy.length; i++) {
            arrCopy[i] = i;
        }
        System.out.println("复制数组nums后的arrCopy数组：");
        for (int i = 0; i < arrCopy.length; i++) {
            System.out.print("arrCopy[" + i + "]=" + arrCopy[i] + "\t");
        }
        System.out.println();

        System.out.println("更改数组arrCopy后的nums数组：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[" + i + "]=" + nums[i] + "\t");
        }
        System.out.println();
    }    
}
