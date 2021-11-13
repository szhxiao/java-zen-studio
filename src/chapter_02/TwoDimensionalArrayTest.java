/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 二维数组声明与初始化
 */
public class TwoDimensionalArrayTest {
    public static void main(String[] args) {
        // 数组声明与静态初始化
        int[][] arr = new int[][] {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        // int [][] arr = new int[3][];
        // arr[0] = new int[] {1, 2, 3};
        // arr[1] = new int[] {4, 5};
        // arr[2] = new int[] {6, 7, 8, 9};

        // 数组声明与动态初始化
        String[][] booksInfo = new String[3][2];
        booksInfo[0][0] = "Core Java";
        booksInfo[0][1] = "Cay S. Horstmann";
        booksInfo[1][0] = "Thinking in Java";
        booksInfo[1][1] = "Bruce Eckel";
        booksInfo[2][0] = "Effective Java";
        booksInfo[2][1] = "Joshua Bloch";

        System.out.println("arr = " + arr);
        System.out.println("arr.length = " + arr.length);
        System.out.println("arr[0] = " + arr[0]);
        System.out.println("arr[1] = " + arr[1]);
        System.out.println("arr[2] = " + arr[2]);
        // for循环遍历数组元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("a[" + i + "][" + j +"]=" + arr[i][j] + "\t");
            }
            System.out.println();
        }

        // for-each遍历数组元素
        System.out.println("booksInfo = " + booksInfo);
        System.out.println("booksInfo[0] = " + booksInfo[0]);
        System.out.println("booksInfo[1] = " + booksInfo[1]);
        System.out.println("booksInfo[2] = " + booksInfo[2]);
        for (String[] book : booksInfo) {
            for (String strings : book) {
                System.out.print(strings + ", ");
            }
            System.out.println();
        }
    }    
}
