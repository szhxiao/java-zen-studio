/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * 
 */
public class TransactionTest {

    public static void testUpdateWithTx() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            // 1. 取消数据自动提交
            conn.setAutoCommit(false);

            String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE `user` = ?";
            update(conn, sql1, "AA");

            // 模拟网络异常
            System.out.println(10/0);

            String sql2 = "UPDATE user_table SET balance = balance + 100 WHERE `user` = ?";
            update(conn, sql2, "BB");

            // 2. 提交数据
            conn.commit();

            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();

            // 3. 出现异常时回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }


    public static void testTransactionSelect() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            // 获取当前连接的隔离级别
            System.out.println(conn.getTransactionIsolation());
            // 设置数据库的隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            // 取消自动提交数据
            conn.setAutoCommit(false);
            String sql = "SELECT `user` name,password,balance FROM user_table WHERE `user`=?";
            User user = getInstance(conn, User.class, sql, "CC");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void testTransactionUpdate() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql = "UPDATE user_table SET balance = ? WHERE `user` = ?";
            update(conn, sql, 5000, "CC");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("修改结束");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用增删改操作
     * 增加数据库事务
     *
     * @param sql 预编译SQL语句
     * @param args 可变参数列表
     */
    public static void update(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        try {
            // 1. 预编译sql语句
            ps = conn.prepareStatement(sql);
            // 2. 填充占位符，占位符个数等于可变形参个数
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 3. 执行操作
            ps.execute();
            System.out.println("提示：更新成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭资源
            JDBCUtils.closeResource(null, ps);
        }
    }

    /**
     * 查询返回一条记录
     * 增加数据库事务
     *
     * @param clazz 对象类
     * @param sql 预编译SQL语句
     * @param args 可变参数
     * @param <T> 类型
     * @return 一个对象
     */
    public static <T> T getInstance(
            Connection conn, Class<T> clazz, String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            // 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            // 获取结果集
            rs = ps.executeQuery();

            // 获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i+1);
                    // 获取列别名
                    String columnLabel = rsmd.getColumnLabel(i+1);

                    // 每个属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);

                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
    
    public static void main(String[] args) {
//        testUpdateWithTx();
        testTransactionSelect();
        testTransactionUpdate();
    }
}
