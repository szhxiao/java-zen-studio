/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 测试if条件语句
 */
public class IfTest {
    public static void main(String[] args) {
        // 获取键盘输入
        System.out.println("请输入年龄：（20）");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        // 进行条件判断
        if (age < 0) {
            System.out.println("输入数据错误");
        } else if (age < 18) {
            System.out.println("少年");
        } else if (age < 35) {
            System.out.println("青年");
        } else if (age < 60) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }
}

/**
 * output:
 * 
 */
