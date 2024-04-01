/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class NewInstanceTest {

    public static void testNewInstance() 
        throws IllegalAccessException, InstantiationException {
        Class<Person> classPerson = Person.class;
        Person p = classPerson.newInstance();
        System.out.println(p);
    }

    /**
     * 获取类的实例
     * 
     * @param classPath 全类名
     * @return 类实例
     * @throws ReflectiveOperationException
     */
    public static Object getInstance(String classPath) 
        throws ReflectiveOperationException {
        Class clazz = Class.forName(classPath);
        // clazz.newInstance() can be replaced by 
        // clazz.getDeclaredConstructor().newInstance()
        return clazz.getDeclaredConstructor().newInstance();
    }
    
    public static void main(String[] args) throws Exception {
        testNewInstance();
    }    
}
