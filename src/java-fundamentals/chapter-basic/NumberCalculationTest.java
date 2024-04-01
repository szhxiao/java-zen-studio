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
public class NumberCalculationTest {
    public static void main(String[] args) {
        // 获取键盘输入
        System.out.println("请输入要计算的表达式：(1.0 + 2.0)");
        Scanner in = new Scanner(System.in);
        
        double num1 = in.nextDouble();
        String operator = in.next();
        double num2 = in.nextDouble();

        // 逻辑判断并计算
        if (operator.equals("+")) {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        } else if (operator.equals("-")) {
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        } else if (operator.equals("*")) {
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        } else if (operator.equals("/")) {
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        } else if (operator.equals("%")) {
            System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        } else {
            System.out.println("输入表达式错误");
        }
    }
}

/**
 * output:
 * 
 */
