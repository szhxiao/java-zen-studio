/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.Calendar;

/**
 * 
 */
public class CalendarTest {
    public static void main(String[] args) {
        // 创建Calendar子类对象，即GregorianCalendar

        // 调用Calendar的静态方法
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        
        // 常用方法
        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        // get()
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.getTime()); 

    }    
}
