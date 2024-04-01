/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Lambda表达式
 * 
 * -> 左边：Lambda形参列表（即接口中的抽象方法形参列表）
 * -> 右边：Lambda体（方法体）
 * 
 * 本质：作为接口的实例
 */
public class LambdaTest {

    public static void test() {
        Runnable r2 = () -> System.out.println("I love China");
        r2.run();
    }
    
    public static void main(String[] args) {
        test();
    }    
}
