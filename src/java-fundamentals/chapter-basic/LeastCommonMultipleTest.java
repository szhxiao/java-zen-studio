/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 寻找两个整数的最小公倍数
 */
public class LeastCommonMultipleTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意两个整数: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        // 取两数中较大的
        int maxNum = (num1 > num2) ? num1 : num2;
        int multiple = maxNum;
        for (int i = maxNum; i <= num1 * num2 ; i++) {
            if ((i % num1 == 0) && (i % num2 == 0)) {
                multiple = i;
                break;
            }
        }
        System.out.println(num1 + "和" + num2 + "的最小公倍数数为：" + multiple);
    }
}

/**
 * output:
 * 
 */
