/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试强制类型转换
 */
public class NarrowConversionTest {
    public static void main(String[] args) {

        double d = 3.14159265;
        // 强制类型转换，引起精度丢失
        float f = (float)d;
        System.out.println(f);

        // 强制类型转换，截断操作
        int i = (int)f;
        System.out.println(i);

        // 强制类型转换，引起数据溢出
        int i2 = 128;
        byte b = (byte)i2;
        System.out.println(b);
    }
}

/**
 * output:
 * 3.1415927
 * 3
 * -128
 */
