/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试整型、浮点型数据类型
 */
public class NumberTest {
    public static void main(String[] args) {
        // byte的范围为-128~127
        byte b1 = -120;
        System.out.println("b1 = " + b1);

        // byte b2 = 128;
        // System.out.println("b2 = " + b2);

        // long类型的值要以l或L作为数值后缀
        long l = 123456789L;
        System.out.println(l);

        double d = 2.765;
        System.out.println(d);

        // float类型的值要以f或F作为数值后缀，否则默认为double类型
        // float f = 1.742;
        float f = 1.742F;
        System.out.println(f);
    }
}
