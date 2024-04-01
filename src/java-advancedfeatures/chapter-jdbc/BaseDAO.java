/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装数据表操作
 */
public abstract class BaseDAO {

    /**
     * 通用数据表更新操作
     * 增加数据库事务，增、删、改
     *
     * @param conn 数据库连接
     * @param sql 预编译SQL语句
     * @param args 参数列表
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
     * 通用数据表查询操作
     * 增加数据库事务，返回单个对象
     *
     * @param conn 数据库连接
     * @param clazz 对象类型
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 返回数据库查询对象，
     *         若不存在，则返回null
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

    /**
     * 通用数据表查询操作
     * 增加数据库事务，返回查询所得对象集合
     *
     * @param conn 数据库连接
     * @param clazz 对象类型
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 返回数据库查询所得对象集合
     *         若不存在，则返回null
     */
    public static <T> List<T> getForList(
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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /**
     * 查询特殊值
     *
     * @param conn 数据库连接
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 特殊值
     */
    public static <T> T getValue(Connection conn, String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return (T) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
    
    public static void main(String[] args) {
        
    }    
}
