/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 方法重载
 */

public class OverloadTest {

    public int max(int i, int j) {
        return (i > j) ? i : j;
    }

    public long max(long a, long b) {
        return (a > b) ? a : b;
    }

    public double max(double a, double b) {
        return (a > b) ? a : b;
    }

    public double max(double a, double b, double c) {
        double temp = max(a, b);
        return max(temp, c);
    }

    public static void main(String[] args) {
        
    }    
}
