/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */


import java.util.Scanner;

/**
 * 打印1至任意整数内的所有质数
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入任意整数：");
        int number = input.nextInt();

        boolean isPrime = true;
        int count = 0;
        
        // 记录算法开始时间
        // long startTime = System.currentTimeMillis();

        for (int i = 2; i <= number; i++) {
            // 判断i是否为质数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + "\t");
                count++;
                // 每行输出5个数
                if (count % 5 == 0) {
                    System.out.println();
                }
            }

            // 重置isPrime
            isPrime = true;
        }
        // 记录算法结束时间
        // long endTime = System.currentTimeMillis();
        // System.out.println();
        // System.out.println("时间开销：" + (endTime - startTime) + "ms");
    }
}

/**
 * output:
 * 
 */
