/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 */
public class JDBCUtilsDBCP {
    private static DataSource source = null;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(new File("src/chapter_13/dbcp.properties"));
            properties.load(fis);
            source = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Connection conn = source.getConnection();
        System.out.println("连接成功：" + conn);
        return conn;
    }
    
    public static void main(String[] args) {
        
    }    
}
