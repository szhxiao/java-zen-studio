/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 测试switch条件语句
 */
public class MonthAndSeasonTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入当前月份: (1~12)");
        int month = input.nextInt();

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("春季，万物复苏");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季，百花齐放");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季，稻谷飘香");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("冬季，千里冰封");
                break;
        }
    }
}

/**
 * output:
 * 
 */
