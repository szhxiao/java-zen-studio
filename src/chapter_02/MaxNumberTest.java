/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试三元运算符
 */
public class MaxNumberTest {
    public static void main(String[] args) {
        int x = 19;
        int y = 30;
        int z = -2;

        // 获取两个数的最大值
        int temp = (x > y) ? x : y;
        int max = (temp > z) ? temp : z;
        System.out.println("The max number is " + max);
    }
}

/**
 * output:
 * 
 */
