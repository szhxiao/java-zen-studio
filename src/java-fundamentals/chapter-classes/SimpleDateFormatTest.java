/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date类
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws Exception {
        // 使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        String str = "1993/12/10 下午6:04";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        // 带参数的构造器
        SimpleDateFormat nsdf = 
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 字符串必须符合构造格式
        String nstr = "2001-07-04 18:13:00";
        Date ndate = nsdf.parse(nstr);
        System.out.println(ndate);

        // 字符串转换为数据库date类型
        String birth = "2022-01-10";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = dateFormat.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(birthday.getTime());
        System.out.println(birthDate);
    }    
}
