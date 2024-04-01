/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant
 */
public class InstantTest {
    public static void main(String[] args) {
        // 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间偏移量
        OffsetDateTime localTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(localTime);

        long milli = instant.toEpochMilli();
        System.out.println(milli);
    }    
}
