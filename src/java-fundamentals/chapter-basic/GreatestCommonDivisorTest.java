/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st  
 */

import java.util.Scanner;

/**
 * 寻找两个整数的最大公约数
 */
public class GreatestCommonDivisorTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意两个整数: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        // 取两数中较小的
        int minNum = (num1 < num2) ? num1 : num2;
        int divisor = 1;
        for (int i = minNum; i >= 1; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                divisor = i;
                break;
            }
        }
        System.out.println(num1 + "和" + num2 + "的最大公约数为：" + divisor);
    }
}

/**
 * output:
 * 
 */
