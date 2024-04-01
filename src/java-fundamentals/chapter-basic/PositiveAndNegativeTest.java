/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 从键盘读入整数，判断正数和负数个数，输入为0时结束
 */
public class PositiveAndNegativeTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意个整数: ");

        // 记录正数个数
        int positiveNumbers = 0;
        // 记录负数个数
        int negativeNumbers = 0;
        
        while (true) {
            int number = input.nextInt();

            if (number > 0) {
                positiveNumbers++;
            } else if (number < 0) {
                negativeNumbers++;
            } else {
                break;
            }
        }
        System.out.println("输入正数个数为：" + positiveNumbers 
            + "，负数个数为：" + negativeNumbers);
    }
}

/**
 * output:
 * 
 */
