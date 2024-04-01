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
public class JDBCUtilsC3P0 {
    // 连接池只需一个
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("testc3p0");

    public static Connection getConnection() throws SQLException {
        Connection conn = cpds.getConnection();
        System.out.println("连接成功：" + conn);
        return conn;
    }
    
    public static void main(String[] args) {
        
    }    
}
