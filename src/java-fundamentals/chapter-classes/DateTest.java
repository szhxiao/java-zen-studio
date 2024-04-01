/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Date;

/**
 * Date类
 */
public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        // 默认调用date1.toString()
        System.out.println(date1);

        long now = System.currentTimeMillis();

        Date date2 = new Date(now);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(77801438019L);
        System.out.println(date3);

        java.sql.Date date4 = new java.sql.Date(date2.getTime());
        System.out.println(date4);
    }    
}
