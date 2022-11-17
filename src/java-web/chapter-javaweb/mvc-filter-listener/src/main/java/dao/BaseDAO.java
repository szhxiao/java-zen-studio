/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package dao;

import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装数据表操作
 */
public abstract class BaseDAO {

    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

    /**
     * 通用数据表更新操作
     * 增加数据库事务，增、删、改
     *
     * @param sql 预编译SQL语句
     * @param args 参数列表
     */
    public void update(String sql, Object ...args)
            throws SQLException {
        conn = JDBCUtils.getInstance().getConnection();
        // 1. 预编译sql语句
        ps = conn.prepareStatement(sql);
        // 2. 填充占位符，占位符个数等于可变形参个数
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1, args[i]);
        }
        // 3. 执行操作
        ps.execute();
        System.out.println("提示：更新成功!");
    }

    /**
     * 通用数据表查询操作
     * 增加数据库事务，返回单个对象
     *
     * @param clazz 对象类型
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 返回数据库查询对象，
     *         若不存在，则返回null
     */
    public <T> T getInstance(Class<T> clazz,
                                    String sql, Object...args) throws Exception {
        conn = JDBCUtils.getInstance().getConnection();
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
                Object columnValue = rs.getObject(i + 1);
                // 获取列别名
                String columnLabel = rsmd.getColumnLabel(i + 1);

                // 每个属性赋值
                Field field = clazz.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(t, columnValue);

            }
            return t;
        }
        return null;
    }

    /**
     * 通用数据表查询操作
     * 增加数据库事务，返回查询所得对象集合
     *
     * @param clazz 对象类型
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 返回数据库查询所得对象集合
     *         若不存在，则返回null
     */
    public <T> List<T> getForList(Class<T> clazz,
                String sql, Object...args) throws Exception {
        conn = JDBCUtils.getInstance().getConnection();
        ps = conn.prepareStatement(sql);

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
    }

    /**
     * 查询特殊值
     *
     * @param sql 预编译SQL语句
     * @param args 参数列表
     * @param <T> 对象类型
     * @return 特殊值
     */
    public <T> T getValue(String sql, Object...args) throws SQLException {
        conn = JDBCUtils.getInstance().getConnection();
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1, args[i]);
        }

        rs = ps.executeQuery();
        if (rs.next()) {
            return (T) rs.getObject(1);
        }
        return null;
    }
}
