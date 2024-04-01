 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库操作工具类
 * 使用Druid数据库连接池
 */
public class JDBCUtils {
    private static JDBCUtils instance;
    private DataSource source = null;

    public static JDBCUtils getInstance() {
        if (instance == null) {
            instance = new JDBCUtils();
        }
        return instance;
    }

    private JDBCUtils() {
        try {
            // 数据源配置
            Properties properties = new Properties();
            // 读取配置文件
            InputStream is = JDBCUtils.class.getResourceAsStream("/druid.properties");
            properties.load(is);
            source = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception {
        Connection conn = null;
        conn = source.getConnection();
//        System.out.println("连接成功：" + conn);
        return conn;
    }

    public static void closeResource(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     *
     * @param conn 数据库连接
     * @param ps 预编译SQL语句
     */
    public static void closeResource(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

    }    
}
