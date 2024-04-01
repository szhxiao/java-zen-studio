/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 可变个数形式参数
 */

public class MethodArgsTest {
    public void print(int i) {
        System.out.println("i = " + i);
    }

    public void print(String str) {
        System.out.println("str: " + str);
    }

    public void print(String ...strings) {
        System.out.print("strings: ");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MethodArgsTest mat = new MethodArgsTest();
        mat.print(2021);
        mat.print();
        mat.print("hello");
        mat.print("hello", "java", "world");
    }    
}
