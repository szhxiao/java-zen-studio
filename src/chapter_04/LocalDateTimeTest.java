/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * LocalDate, LocalTime, LocalDateTime
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime birthday = LocalDateTime.of(1993, 12, 30, 14, 30, 00);
        System.out.println(birthday);

        // getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());

        // withXxx()
        LocalDate future = localDate.withDayOfMonth(16);
        System.out.println(localDate);
        System.out.println(future);
    }    
}
