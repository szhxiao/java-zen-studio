/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;


/**
 * 
 */
public class PrepareStatementTest {

    public static void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 读取配置文件的基本信息
            InputStream is = PrepareStatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

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

            // 4. 预编译SQL语句
            String sql_insert = "INSERT INTO customers (name,email,birth) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql_insert);

            // 5. 填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@163.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2022-03-09");
            ps.setDate(3, new java.sql.Date(date.getTime()));

            // 6. 执行操作
            ps.execute();
            System.out.println("插入成功");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
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

    }

    public static void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1. 获取数据库连接
            conn = JDBCUtils.getConnection();

            // 2. 预编译sql语句，返回PreparedStatement实例
            String sql_update = "UPDATE customers SET name = ? WHERE id = ?";
            ps = conn.prepareStatement(sql_update);

            // 3. 填充占位符
            ps.setString(1, "莫扎特");
            ps.setObject(2, 19);

            // 4. 执行
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    /**
     * 通用增删改操作
     *
     * @param sql
     * @param args
     */
    public static void update(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库连接
            conn = JDBCUtils.getConnection();
            // 2. 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 3. 填充占位符，占位符个数等于可变形参个数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 4. 执行操作
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }

    public static void select() {

    }


    
    public static void main(String[] args) {
//        testInsert();
//        testUpdate();
        String sql = "DELETE FROM customers WHERE id = ?";
        update(sql, 13);
    }


}
