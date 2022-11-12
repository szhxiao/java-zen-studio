/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 数组反转
 */
public class ArrayReverseTest {
    public static void main(String[] args) {
        
        String[] str = {"hello", "java", "world", ",", "I", "love", "you"};
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();

        // 方式一
        for (int i = 0; i < str.length / 2; i++) {
            String temp = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-i-1] = temp;
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();

        // 方式二
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }    
}
