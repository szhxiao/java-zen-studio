/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 
 */
public class MethodRefTest {

    /**
     * 情况一：
     * 对象::实例方法
     */
    public static void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("大概是因为懒");

        System.out.println("------------------");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("学习的苦要主动去吃");
    }

    /**
     * 情况二：
     * 类::静态方法
     */
    public static void test2() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(5, 3));

        System.out.println("------------------");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(7, 13));
    }

    /**
     * 情况三：
     * 类::实例方法
     */
    public static void test3() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("love", "lie"));

        System.out.println("------------------");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("China", "light"));
    }
    
    public static void main(String[] args) {
        // test1();
        test2();
    }    
}
