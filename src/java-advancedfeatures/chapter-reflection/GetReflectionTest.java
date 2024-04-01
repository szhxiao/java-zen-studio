import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class GetReflectionTest {

    public static void testGetFields() throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();

        // 获取指定属性，声明为public
        Field id = clazz.getField("id");
        id.set(p, 1001);
        System.out.println(id.get(p));

        // 获取指定属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "James");
        System.out.println(name.get(p));
    }

    public static void testGetMethods() throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(p, "CHN");
    }
    
    public static void main(String[] args) throws Exception {
        // testGetFields();
        testGetMethods();
    }    
}
