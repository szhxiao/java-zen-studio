/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * try-catch-finally
 */
public class TryCatchFinallyTest {
    public static void main(String[] args) {
        try {
            System.out.println(5 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("the program is over");
        }
    }    
}
