/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st 
 */

/**
 * 测试字符类型
 */
public class CharTest {
    public static void main(String[] args) {
        // 声明单个字符
        char a = 'a';
        System.out.println(a);

        // 转义字符
        System.out.print("Welcome to " + "\t");
        System.out.print("Beijing" + "\n");

        // 使用Unicode编码输出字符

        char c = '\u0022';
        System.out.println(c);
    }
}

/**
 * output:
 * a
 * Welcome to 	Beijing
 * "
 */
