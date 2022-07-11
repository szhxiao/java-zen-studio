/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 测试算术运算符
 */
public class ArithmeticTest {
    public static void main(String[] args) {

        // /除法运算符
        System.out.println("----------除法运算----------");
        int num1 = 22;
        int num2 = 3;

        int result1 = num1 / num2;
        System.out.println("22 / 3 = " + result1);

        int result2 = num1 / num2 * num2;
        System.out.println("22 / 3 * 3 = " + result2);

        double result3 = num1 / (num2 + 0.0);
        System.out.println("22 / (3 + 0.0) = " + result3);

        double result4 = (double)num1 / num2;
        System.out.println("(double)22 / 3 = " + result4);

        
        // %取模运算符
        // 取模结果与被模数符号一致
        System.out.println("----------取模运算----------");
        System.out.println("12 % 5 = " + 12 % 5);
        System.out.println("(-12) % 5 = " + (-22 % 3));
        System.out.println("(-12) % (-5) = " + (-12) % (-5));
        System.out.println("12 % (-5) = " + 12 % (-5));

        

        // ++num, 先加1后赋值
        // num++, 先赋值后加1
        System.out.println("----------自增运算----------");
        int a1 = 9;
        int a2 = 100;
        System.out.println("自增运算a前: a1 = " + 1 + ", a2 = " + a2);
        System.out.println("执行自增运算: a1++ = " + (a1++) + ", ++a2 = " + (++a2));
        System.out.println("自增运算后: a1 = " + a1 + ", a2 = " + a2);

        // 自增自减运算符不改变数据原始类型
        byte a = 127;
        a++;
        System.out.println("127++ = " + a);
        
        System.out.println("----------自减运算----------");
        int d1 = 9;
        int d2 = 100;
        System.out.println("自减运算前: d1 = " + d1 + ", d2 = " + d2);
        System.out.println("执行自减运算: d1-- = " + (d1--) + ", --d2 = " + (--d2));
        System.out.println("自减运算后: d1 = " + d1 + ", d2 = " + d2);

        byte d = -128;
        d--;
        System.out.println("-128-- = " + d);
    }
}

/**
 * output:
 * 
 */
