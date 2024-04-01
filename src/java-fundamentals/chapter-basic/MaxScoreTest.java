/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Scanner;

/**
 * 数组
 */
public class MaxScoreTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入学生人数： ");
        int numbers = in.nextInt();

        // 通过键盘输入为数组元素赋值
        int[] scores = new int[numbers];
        int maxScore = 0;
        System.out.println("请分别输入学生成绩：");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = in.nextInt();
            if (maxScore < scores[i]) {
                maxScore = scores[i];
            }
        }

        // 获取最好成绩
        
        // int maxScore = 0;
        // for (int i = 0; i < scores.length; i++) {
        //     if (scores[i] > maxScore) {
        //         maxScore = scores[i];
        //     }
        // }
        System.out.println("最高成绩为：" + maxScore);

        // 判断学生成绩等级并输出
        char level;
        for (int i = 0; i < scores.length; i++) {
            if (maxScore - scores[i] <= 10) {
                level = 'A';
            } else if (maxScore - scores[i] <= 20) {
                level = 'B';
            } else if (maxScore - scores[i] <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }
            System.out.println("Student" + i + "'score is " + scores[i] + ", grade is " + level);
        }
    }    
}
