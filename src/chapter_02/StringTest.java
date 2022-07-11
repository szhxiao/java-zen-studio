/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试String类型
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(str);

        char c = 'a';   // a->97, A->65
        int num = 10;
        // 107Hello
        System.out.println(c + num + str);
        // aHello10
        System.out.println(c + str + num);
    }
}
