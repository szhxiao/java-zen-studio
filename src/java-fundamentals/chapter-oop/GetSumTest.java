/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 递归实现求n个自然数的和
 */
public class GetSumTest {

    public int getSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getSum(n-1);
        }
    }
    public static void main(String[] args) {
        GetSumTest gst = new GetSumTest();
        int sum = gst.getSum(100);
        System.out.println("从1到100的和是：" + sum);
    }    
}
