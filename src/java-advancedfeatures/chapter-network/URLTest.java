/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 */
public class URLTest {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/index.html");

            // 获取URL协议名
            System.out.println(url.getProtocol());
            // 获取URL主机名
            System.out.println(url.getHost());
            // 获取URL的端口号
            System.out.println(url.getPort());
            // 获取URL的文件路径
            System.out.println(url.getPath());
            // 获取URL文件名
            System.out.println(url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }    
}
