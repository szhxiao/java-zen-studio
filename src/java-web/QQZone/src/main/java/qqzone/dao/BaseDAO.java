/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

package qqzone.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装数据库基础操作
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
    public <T> T query(Class<T> clazz,
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

                if (field != null) {
                    // 获取当前字段的类型名称
                    String type = field.getType().getName();
                    // 判断如果是自定义类型，需要调用该类型事带一个参数的构造方法
                    // 创建出自定义的实例对象，将实例对象赋值给该属性
                    if (isMyType(type)) {
                        Class typeClass = Class.forName(type);
                        Constructor constructor =
                                typeClass.getDeclaredConstructor(java.lang.Integer.class);
                        columnValue = constructor.newInstance(columnValue);
                    }

                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
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
    public <T> List<T> queryForList(Class<T> clazz,
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
                if (field != null) {
                    // 获取当前字段的类型名称
                    String type = field.getType().getName();
                    // 判断如果是自定义类型，需要调用该类型事带一个参数的构造方法
                    // 创建出自定义的实例对象，将实例对象赋值给该属性
                    if (isMyType(type)) {
                        Class typeClass = Class.forName(type);
                        Constructor constructor =
                                typeClass.getDeclaredConstructor(java.lang.Integer.class);
                        columnValue = constructor.newInstance(columnValue);
                    }

                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
            }
            list.add(t);
        }
        return list;
    }

    private boolean isMyType(String type) {
        return !isNotMyType(type);
    }

    private boolean isNotMyType(String type) {
        return "java.lang.Boolean".equals(type)
                || "java.lang.Byte".equals(type)
                || "java.lang.Character".equals(type)
                || "java.lang.Double".equals(type)
                || "java.lang.Enum".equals(type)
                || "java.lang.Float".equals(type)
                || "java.lang.Integer".equals(type)
                || "java.lang.Long".equals(type)
                || "java.lang.Short".equals(type)
                || "java.lang.String".equals(type)
                || "java.util.Date".equals(type)
                || "java.sql.Date".equals(type)
                || "java.time.LocalDateTime".equals(type);
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
