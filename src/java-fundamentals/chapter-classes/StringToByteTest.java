/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 
 */
public class StringToByteTest {
    public static void main(String[] args) {
        String str1 = "abc123";
        // 使用默认字符集编码
        byte[] byteArr1 = str1.getBytes();
        System.out.println(Arrays.toString(byteArr1));

        String str2 = "中国";
        byte[] byteArr2 = str2.getBytes();
        System.out.println(Arrays.toString(byteArr2));
        
        try {
            // 使用GBK字符集进行编码
            byte[] gbks = str2.getBytes("gbk");
            System.out.println(Arrays.toString(gbks));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("--------------");

        // 使用默认字符集解码
        String str3 = new String(byteArr2);
        System.out.println(str3);
    }    
}
