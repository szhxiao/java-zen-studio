/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */
public class StringTest {

    public static void testImmutability(){
        // String不可变性
        // 字面量定义方式
        String str1 = "hello";
        String str2 = "hello";
        System.out.println("str1 == str2 : " + (str1 == str2));

        str1 = "world";

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("------------");

        String str3 = "hello";
        str3 += " java";
        System.out.println("str3 = " + str3);
        System.out.println("str2 = " + str2);
        System.out.println("------------");

        String str4 = "hello";
        str4.replace("h", "H");
        System.out.println("str4 = " + str4);
        // System.out.println("str2 = " + str2);
    }

    public static void testInstantiate() {
        // String的实例化方式
        // 字符量定义方式（数据声明在方法区中的字符串常量池）
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        // 构造器定义方式（数据在堆空间中开辟后赋值）
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s3 == s4: " + (s3 == s4));
    }

    public static void testSplit() {
        String s1 = "JavaEE";
        String s2 = "Hadoop";

        String s3 = "JavaEEHadoop";
        String s4 = "JavaEE" + "Hadoop";
        String s5 = s1 + "Hadoop";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;
        // 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量；
        // 只要其中有一个变量，结果就在堆中
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);

        // 返回值得到的s8使用常量池中已经存在的数据
        String s8 = s5.intern();
        System.out.println(s3 == s8);
    }

    /**
     * length()
     */
    public static void testLength() {
        String str = "method length()";
        System.out.println("str.length = " + str.length());
    }

    /**
     * charAt()
     */
    public static void testCharAt() {
        String str = "if you sit down at set of sun";
        System.out.println(str.charAt(7));
    }

    /**
     * toLowerCase()
     */
    public static void testToLowerCase() {
        String str = "THAT FELL LIKE SUNSHINE WHERE IT WENT";
        String strLowerCase = str.toLowerCase();
        System.out.println(str);
        System.out.println(strLowerCase);
    }

    /**
     * compareTo()
     */
    public static void testCompareTo() {
        String str1 = "abc";
        String str2 = "abe";
        System.out.println(str1.compareTo(str2));
    }

    public static void main(String[] args) {

        // testCharAt();

        // testToLowerCase();

        testCompareTo();

    }    
}
