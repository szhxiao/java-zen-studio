/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 */
public class C3P0Test {

    // 方式一
    public static void testGetConnection1() throws Exception {
        // 获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("mysql");

        // 设置初始时数据库连接池中的连接数
//        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    // 方式二：使用配置文件
    public static void testGetConnection2() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("testc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
    
    public static void main(String[] args) throws Exception {
        testGetConnection2();
    }    
}
