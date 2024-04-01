/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class ClassLoaderTest {
    
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 系统类加载器
        System.out.println(classLoader);
        // 扩展类加载器
        System.out.println(classLoader.getParent());
        // 引导类加载器，无法获取，主要负责加载java的核心类库
        System.out.println(classLoader.getParent().getParent());
    }    
}
