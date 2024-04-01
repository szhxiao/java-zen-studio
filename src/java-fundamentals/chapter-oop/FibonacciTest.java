/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 递归实现求n个自然数的乘积，即n!
 */
public class FibonacciTest {
    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        FibonacciTest ft = new FibonacciTest();
        for (int i = 1; i <= 20; i++) {
            System.out.print(ft.fibonacci(i) + "\t");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }    
}
