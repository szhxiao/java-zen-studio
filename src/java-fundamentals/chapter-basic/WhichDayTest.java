/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 测试switch条件语句
 * 从键盘获取日期，输出是今年的哪一天
 */
public class WhichDayTest {
    public static void main(String[] args) {
        // 从键盘获取输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入当前日期: （2021 11 9即表示为2021年11月9日）");
        int year = input.nextInt();
        int month = input.nextInt();
        int day = input.nextInt();

        int sumDays = 0;

        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                // 判断是否为闰年
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    sumDays += 29;
                } else {
                    sumDays += 28;
                }      
            case 2:
                sumDays += 31;      // 1月的31天
            case 1:
                sumDays += day;
        }
        System.out.println(year + "年" + month + "月" + day + "日是" + year + "年的第" + sumDays + "天");
    }
}

/**
 * output:
 * 
 */
