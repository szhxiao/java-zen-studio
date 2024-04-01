/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 工具类
 */
public class TSUtility {
    private static Scanner in = new Scanner(System.in);

    /**
     * Get user's selection from keyboard
     * 
     * @return the user's selection
     */
    public static char getMenuSelection() {
        char item;
        while (true) {
            String str = readKeyBoard(1, false);
            item = str.charAt(0);
            if (item != '1' && item != '2' 
                && item != '3' && item != '4' && item != '5') {
                System.out.println("提示：选择错误，请重新输入");
            } else {
                break;
            }
        }
        return item;
    }

    /**
     * Get 'Enter' from keyboard
     */
    public static void getReturn() {
        System.out.print("提示：按回车键继续...");
        readKeyBoard(100, true);
    }

    /**
     * Return the integer got from keyboard.
     * 
     * @return the integer
     */
    public static int getInt() {
        int num;
        while (true) {
            String str = readKeyBoard(3, false);
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入数字错误，请重新输入");
            }
        }
        return num;
    }

    /**
     * Return true if the user select Yes.
     * 
     * @return {@code true} if the user select Y;
     *         {@code false} otherwise
     */
    public static char getConfirmSelection() {
        char selection;
        while (true) {
            String str = readKeyBoard(1, false).toUpperCase();
            selection = str.charAt(0);
            if (selection == 'Y' || selection == 'N') {
                break;
            } else {
                System.out.println("提示：选择无效，请重新输入");
            }
        }
        return selection;
    }

    /**
     * Get input from keyboard.
     * 
     * @param limit
     * @param blankReturn
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（不大于" + limit + "）错误，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

    public static void main(String[] args) {
        
    }
}
