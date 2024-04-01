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
public class MarkNumberTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入任意整数: ");
        int num = input.nextInt();

        for (int i = 0; i <= num; i++) {
            System.out.print(i);
            if (i % 3 == 0) {
                System.out.print("\t" + "foo");
            } 
            if (i % 5 == 0) {
                System.out.print("\t" + "biz");
            }
            if (i % 7 == 0) {
                System.out.print("\t" + "baz");
            }
            System.out.println();
        }
    }
}

/**
 * output:
 * 
 */
