/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 数组声明与初始化
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 数组声明与静态初始化
        int[] id = {1, 2, 3, 4, 5};

        // 数组声明与动态初始化
        String[] books = new String[5];
        books[0] = "Core Java";
        books[1] = "Thinking in Java";
        books[2] = "Effective Java";
        books[3] = "Professional JavaScript for Web Developers";
        books[4] = "Python Crash Course";

        System.out.println("id.length = " + id.length);
        // for循环遍历数组元素
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + "\t");
        }
        System.out.println();

        // for-each遍历数组元素
        for (String book : books) {
            System.out.println(book);
        }
    }    
}
