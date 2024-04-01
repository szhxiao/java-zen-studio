/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 */
public class StringUtils {
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static Date stringToDate(String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = dateFormat.parse(s);
        return new Date(date.getTime());
    }


    public static void main(String[] args) throws Exception {
        System.out.println(stringToDate("1970-8-9"));
    }    
}
