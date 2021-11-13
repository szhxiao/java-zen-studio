/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 定义一个int型的一维数组，包含10个元素，分别赋10个随机值
 * 并计算输出数组元素中的最大值、最小值、总和及平均值
 */
public class ArrayNumbersTest {
    public static void main(String[] args) {
        int[] arr = new int[10];

        // 数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (99 - 10 + 1) + 10);
        }

        // 求数组元素的最大值、最小值、总和、平均值
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            // 最大值
            if (arr[i] > max) {
                max = arr[i];
            }
            // 最小值
            if (arr[i] < min) {
                min = arr[i];
            }
            // 总和
            sum += arr[i];

            System.out.print("a[" + i + "]=" + arr[i] + "\t");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        average = sum / arr.length;

        System.out.println("随机数组中最大值为：" + max);
        System.out.println("随机数组中最小值为：" + min);
        System.out.println("随机数组元素总和为：" + sum);
        System.out.println("随机数组元素平均值为：" + average);
    }    
}
