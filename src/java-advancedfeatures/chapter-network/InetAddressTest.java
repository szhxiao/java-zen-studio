/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 */
public class InetAddressTest {
    
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);

            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu);

            InetAddress bilibili = InetAddress.getByName("www.bilibili.com");
            System.out.println("Name: " + bilibili.getHostName());
            System.out.println("Address: " + bilibili.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }    
}
