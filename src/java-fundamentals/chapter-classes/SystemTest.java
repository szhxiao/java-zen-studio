/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class SystemTest {

    /**
     * getProperty()
     */
    public static void testGetProperty() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java-version: " + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java-home: " + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os-name: " + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os-version: " + osVersion);
    }
    
    public static void main(String[] args) {
        testGetProperty();
    }    
}
