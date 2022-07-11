/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * DateTimeFormatter
 * 格式化或解析日期、时间
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        // 方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        
        // 格式化
        LocalDateTime local = LocalDateTime.now();
        System.out.println(local);
        String str = formatter.format(local);
        System.out.println(str);
        
        //解析
        TemporalAccessor parse = formatter.parse(str);
        System.out.println(parse);

        // 方式二：自定义格式
        DateTimeFormatter primeFormatter = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        String primeStr = primeFormatter.format(LocalDateTime.now());
        System.out.println(primeStr);
    }    
}
