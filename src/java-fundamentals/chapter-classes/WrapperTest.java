/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 包装类的使用
 */
public class WrapperTest {
    
    public static void main(String[] args) {
        // 基本数据类型 --> 包装类，不推荐调用包装类构造器
        // int num = 10;
        // // 不推荐使用
        // Integer inum = new Integer(num);
        // System.out.println(inum);
        // Integer snum =  new Integer("234");
        // System.out.println(snum);
        // Double d = 3.14;
        // System.out.println(d.toString());

        // Object o1 = true ? new Integer(1) : new Double(2.0);
        // System.out.println(o1);

        // 
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println("i == j: " + (i == j));

        Integer m = 1;
        Integer n = 1;
        System.out.println("m == n: " + (m == n));

        Integer x = 128;
        Integer y = 128;
        System.out.println("x == y: " + (x == y));
    }    
}
