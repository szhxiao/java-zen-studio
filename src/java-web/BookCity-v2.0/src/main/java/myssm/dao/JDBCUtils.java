 /**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

 package myssm.dao;

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

    private ThreadLocal<Connection> threadLocal;

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
            threadLocal = new ThreadLocal<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();

        if (conn == null) {
            conn = source.getConnection();
            threadLocal.set(conn);
        }

        System.out.println("连接成功：" + conn);
        return threadLocal.get();
    }

    public void closeConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
//            threadLocal.set(null);
            threadLocal.remove();
        }
    }

    /**
     * 关闭资源
     *
     * @param ps 预编译SQL语句
     */
    public static void closeResource(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void closeResource(PreparedStatement ps, ResultSet rs) {
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
    }


    public static void main(String[] args) throws Exception {

    }    
}
