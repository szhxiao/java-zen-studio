/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 测试for循环结构
 */
public class ForTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意整数: ");
        int num = input.nextInt();

        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        System.out.println("0 ~ " + num + "间所有整数的和为：" + sum);
    }
}

/**
 * output:
 * 
 */
