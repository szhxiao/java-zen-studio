/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 测试if-else if条件语句
 */
public class NumberSortTest {
    public static void main(String[] args) {
        // 获取键盘输入
        System.out.println("请输入待排序的三个整数：");
        Scanner in = new Scanner(System.in);
        
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();

        if (num1 > num2) {
            if (num3 > num1) {
                System.out.println("数据顺序为: " + num2 + ", " + num1 + ", " + num3);
            } else if (num3 <= num2) {
                System.out.println("数据顺序为: " + num3 + ", " + num2 + ", " + num1);
            } else {
                System.out.println("数据顺序为: " + num2 + ", " + num3 + ", " + num1);
            }
        } else {
            if (num3 > num2) {
                System.out.println("数据顺序为: " + num1 + ", " + num2 + ", " + num3);
            } else if (num3 < num1) {
                System.out.println("数据顺序为: " + num3 + ", " + num1 + ", " + num2);
            } else {
                System.out.println("数据顺序为: " + num1 + ", " + num3 + ", " + num2);
            }
        }
    }
}

/**
 * output:
 * 
 */
