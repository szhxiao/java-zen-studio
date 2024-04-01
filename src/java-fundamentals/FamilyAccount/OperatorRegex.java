/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 用户操作校验
 */
public class OperatorRegex {
    /**
     * 校验菜单选项
     * 
     * @param min
     * @param max
     * @return
     */
    public int validateMenuItem(int min, int max) {
        Scanner in = new Scanner(System.in);
        String regex = "[1-9]{1}";
        int item;

        while (true) {
            System.out.println("请选择要执行的操作（最小为" + min + ", 最大为" + max + "）：");
            String input = in.nextLine();
            if (input.matches(regex)) {
                item = Integer.parseInt(input);
                if (item < min || item > max) {
                    System.out.println("输入菜单选项错误，请重新输入");
                } else {
                    break;
                }
            } else {
                System.out.println("输入内容错误，请检查");
            }
        }
        return item;
    }

    /**
     * 校验收支金额
     * 
     * @return 从键盘获取的输入
     */
    public int validateAccount() {
        Scanner in = new Scanner(System.in);
        String regex = "[1-9]{1-6}";
        int account;

        while (true) {
            System.out.println("请输入收支金额：");
            String input = in.nextLine();
            if (input.matches(regex)) {
                account = Integer.parseInt(input);
                if (account < 0 || item > 100000) {
                    System.out.println("输入收支金额错误，请重新输入");
                } else {
                    break;
                }
            } else {
                System.out.println("输入内容错误，请检查");
            }
        }
        return account;
    }

    /**
     * 校验确认操作
     * 
     * @return Y/y 确认；N/n 取消
     */
    public String validateConfirmSelection() {
        String regex = "[yYnN]{1}";
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请确定是否退出：（Y/N, y/n）");
            String input = in.nextLine();
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }
}
