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
public class Utility {
    private static Scanner in = new Scanner(System.in);
    
    /**
     * 获取用户菜单选择
     * 
     * @return 用户选项
     */
    public static char getMenuSelection() {
        char item;

        while (true) {
            System.out.println("请选择要执行的操作<1-4>");
            String input = in.nextLine();
            item = input.charAt(0);
            if (item != '1' && item != '2' && item != '3' && item != '4' ) {
                System.out.println("输入菜单选项错误，请重新输入");
            } else {
                break;
            }
        }
        return item;
    }

    /**
     * 获取用户收支金额
     * 
     * @return 收支金额
     */
    public static int getMoney() {
        int money;

        while (true) {
            String input = in.nextLine();
            try {
                money = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入金额错误，请重新输入");
            }
        }
        return money;
    }

    /**
     * 获取用户说明信息
     * 
     * @return 说明信息
     */
    public static String getString() {
        String str = in.nextLine();
        return str;
    }

    /**
     * 获取用户确认操作选项
     * 
     * @return 确认操作选项
     */
    public static char getConfirmSelection() {
        char selection;

        while (true) {
            String input = in.nextLine().toUpperCase();
            selection = input.charAt(0);
            if (selection == 'Y' || selection == 'N') {
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        return selection;
    }
}
