/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 参数传递
 */

public class ValueTransferTest {
    public void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }

    public static void main(String[] args) {
        ValueTransferTest vt = new ValueTransferTest();

        int a = 13;
        int b = 19;
        System.out.println("Before swap, a = " + a + ", b = " + b);

        vt.swap(a, b);
        System.out.println("After swap, a = " + a + ", b = " + b);
    }    
}
