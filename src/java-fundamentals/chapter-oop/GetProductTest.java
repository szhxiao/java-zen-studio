/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 递归实现求n个自然数的乘积，即n!
 */
public class GetProductTest {
    public int getProduct(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getProduct(n-1);
        }
    }

    public static void main(String[] args) {
        GetProductTest gpt = new GetProductTest();
        int product = gpt.getProduct(6);
        System.out.println("从1到6的积是：" + product);
    }    
}
