/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * try-catch
 */
public class TryCatchTest {
    public static void main(String[] args) {
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (NumberFormatException e) {
            // System.out.println("java.lang.NumberFormatException");
            // System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("java.lang.NullPointerException");
        } catch (Exception e) {
            System.out.println("java.lang.Exception");
        }
    }    
}
