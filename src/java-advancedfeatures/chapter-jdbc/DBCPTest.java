/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 */
public class DBCPTest {

    // 方式一
    public static void testGetConnection1() throws SQLException {
        // 创建DBCP数据库连接池
        BasicDataSource source = new BasicDataSource();

        // 设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("mysql");

        // 设置数据库连接池管理相关属性
        source.setInitialSize(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    public static void testGetConnection2() throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(new File("src/chapter_13/dbcp.properties"));
        properties.load(fis);
        DataSource source = BasicDataSourceFactory.createDataSource(properties);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
    
    public static void main(String[] args) throws Exception {
        testGetConnection2();
    }    
}
