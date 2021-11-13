/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试自动类型转换
 */
public class AutoConversionTest {
    public static void main(String[] args) {
        byte b = 124;
        int i = 129;
        // 编译错误
        // byte sum = b + i;
        int sum = b + i;
        System.out.println(sum);

        // 自动类型转换
        float f = b;
        System.out.println(f);

        double d = 3.1415;
        // 无法自动进行类型转换
        // int i = d;
        // System.out.println(i);

        double sub = f - d;
        System.out.println(sub);

        // 编写代码时忽略long类型的L后缀时可通过编译，
        // 默认以int类型处理
        long l = 1345668;
        System.out.println(l);

        // 编写代码时忽略float类型后的F后缀时无法通过编译
        // 默认为double型，无法自动转换
        // float f2 = 2.7682;
        // System.out.println(f2);
    }
}

/**
 * output:
 * 253
 * 124.0
 * 120.8585
 */
