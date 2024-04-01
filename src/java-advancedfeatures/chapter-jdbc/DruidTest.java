/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 
 */
public class DruidTest {

    public static void testGetConnection() throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/chapter_13/druid.properties"));
        properties.load(fis);
        DataSource source = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
    
    public static void main(String[] args) throws Exception {
        testGetConnection();
    }    
}
