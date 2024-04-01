/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 
 */
public class ConnectionTest {

    /**
     * 方式一
     */
    public static void testConnection1() {
        Driver driver = null;
        String url = null;
        Properties info = null;
        Connection conn = null;
        try {
            // 1. 获取Driver实现类对象
            driver = new com.mysql.jdbc.Driver();
            // 2. 提供要连接的数据库
            url = "jdbc:mysql://localhost:3306/test";
            // 3. 提供连接所需用户名和密码
            info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "mysql");
            // 4. 获取连接
			conn = driver.connect(url, info);
            System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式二
     * 反射获取
     * 不出现第三方API，具有更好的可移植性
     */
    public static void testConnection2() {
        Driver driver = null;
        String url = null;
        Properties info = null;
        Connection conn = null;
        try {
            // 1. 获取Driver实现类对象，使用反射
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            driver = (Driver)clazz.getDeclaredConstructor().newInstance();
            // 2. 提供要连接的数据库
            url = "jdbc:mysql://localhost:3306/test";
            // 3. 提供连接需要的用户名和密码
            info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "mysql");
            // 4. 获取连接
            conn = driver.connect(url, info);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式三
     */
    public static void testConnection3() {
        Connection conn = null;
        try {
            // 1. 提供连接所需基本信息
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "mysql";

            // 2. 获取Driver实现类对象
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver)clazz.getDeclaredConstructor().newInstance();

            // 3. 注册驱动
            DriverManager.registerDriver(driver);

            // 4. 获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式四
     */
    public static void testConnection4() {
        Connection conn = null;
        try {
            // 1. 提供连接所需基本信息
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "mysql";

            // 2. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 3. 获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式五
     */
    public static void testConnection5() {
        Connection conn = null;
        try {
            // 1. 读取配置文件的基本信息
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(is);;

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driver = pros.getProperty("driver");

            // 2. 加载驱动
            Class.forName(driver);

            // 3. 获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
//        testConnection1();
//        testConnection2();
//        testConnection3();
//        testConnection4();
        testConnection5();
    }    
}
