/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库通用查询操作
 */
public class Query {
    /**
     * 查询返回一条记录
     *
     * @param clazz 对象类
     * @param sql 预编译SQL语句
     * @param args 可变参数
     * @param <T> 类型
     * @return 一个对象
     */
    public static <T> T getInstance(Class<T> clazz, String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    /**
     * 查询返回多条记录
     *
     * @param clazz 对象类
     * @param sql 预编译SQL语句
     * @param args 可变参数
     * @param <T> 类型
     * @return 多个对象
     */
    public static <T> List<T> getForList(Class<T> clazz, String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
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

            // 创建集合对象
            List<T> list = new ArrayList<>();

            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理一行数据中的每一列，给对象赋值
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
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
    
    public static void main(String[] args) {
        String customerQuery = "SELECT id, name, email, birth FROM customers c WHERE id = ?";
        Customer customer = getInstance(Customer.class, customerQuery, 7);
        System.out.println(customer);

        System.out.println("-----------------");

        String orderQuery = "SELECT order_id id, order_name name, order_date date FROM `order` o WHERE order_id < ?";
        List<Order> orderList = getForList(Order.class, orderQuery, 5);
        orderList.forEach(System.out::println);
    }    
}
