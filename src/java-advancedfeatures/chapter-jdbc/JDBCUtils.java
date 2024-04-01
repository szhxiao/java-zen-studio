/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库操作工具类
 */
public class JDBCUtils {

    /**
     * 获取数据库连接
     *
     * @return 数据库连接
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection()
            throws IOException, ClassNotFoundException, SQLException {
         // 1. 读取配置文件基本信息
        InputStream is = ClassLoader.getSystemClassLoader()
                .getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");

        // 2. 加载驱动
        Class.forName(driver);

        // 3. 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("提示：" + conn + "连接成功");
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
    
    public static void main(String[] args) {
        
    }    
}
