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
public class SwitchTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入单科目成绩: (0~100)");
        double score = input.nextDouble();

        int level = (int) score / 10;
        switch (level) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("科目等级评定：不及格");
                break;
            case 6:
            case 7:
                System.out.println("科目等级评定：及格");
                break;
            case 8:
                System.out.println("科目等级评定：良好");
                break;
            case 9:
            case 10:
                System.out.println("科目等级评定：优秀");
                break;
            default:
                System.out.println("成绩输入错误");
                break;
        }
    }
}

/**
 * output:
 * 
 */
