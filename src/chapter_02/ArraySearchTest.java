/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Arrays;

/**
 * 数组查找
 */
public class ArraySearchTest {
    public static void main(String[] args) {

        String[] str = {"hello", "java", "world", ",", "I", "love", "you"};
        String dest = "java";

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();

        // 线性查找
        boolean flag = true;
        for (int i = 0; i < str.length; i++) {
            if (dest.equals(str[i])) {
                System.out.println(dest + "的位置为：" + i);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(dest + "不在数组中");
        }

        // 二分查找
        // 前提：数组必须有序
        int[] nums = new int[] {-30, -15, -9, 0, 1, 3, 5, 8, 13, 14};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        int destNum = 5;
        int head = 0;
        int end = nums.length - 1;
        boolean isFound = true;
        while (head <= end) {
            int middle = (head + end) / 2;
            if (destNum == nums[middle]) {
                System.out.println(destNum + "的位置为：" + middle);
                isFound = false;
                break;
            } else if (nums[middle] > destNum) {
                end = middle - 1;
            } else {
                head = middle + 1;
            }
        }
        if (isFound) {
            System.out.println(destNum + "不在数组中");
        }
    }    
}
