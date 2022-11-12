/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class StringBufferTest {
    
    /**
     * append()
     */
    public static void testAppend() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append(" effort");
        System.out.println(stringBuffer);
    }

    /**
     * replace()
     */
    public static void testReplace() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A great effort it may seem");
        stringBuffer.replace(2, 7, "wasted");
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        // testAppend();
        testReplace();
    }    
}
