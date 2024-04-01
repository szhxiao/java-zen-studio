/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 */
public class ReflectionTest {

    public static void testReflection() throws NoSuchMethodException, 
        InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Person> person = Person.class;
        System.out.println(person);
        Constructor constructor = person.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 20);
        System.out.println(obj.toString());

        System.out.println("------------------");

        Constructor pcon = person.getDeclaredConstructor(String.class);
        pcon.setAccessible(true);
        Person p1 = (Person)pcon.newInstance("Jerry");
        System.out.println(p1);
    }

    /**
     * 获取Class实例的方式
     */
    public static void testGetClass() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性
        Class<Person> class1 = Person.class;
        System.out.println(class1);

        // 方式二：通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class class2 = person.getClass();
        System.out.println(class2);

        // 方式三：调用Class的静态方法：forName(String classPath)
        Class class3 = Class.forName("Person");
        System.out.println(class3);

        // 方式四：使用类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class class4 = classLoader.loadClass("Person");
        System.out.println(class4);
    }
    
    public static void main(String[] args) throws Exception {
        testGetClass();
    }    
}
