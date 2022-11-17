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
public class CustomerQueryTest {
    
    public static void query() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql_query = "SELECT id, name, email, birth FROM customers c WHERE id = 1";
            ps = conn.prepareStatement(sql_query);

            // 执行，并返回结果集
            resultSet = ps.executeQuery();

            // 处理结果集
            // 判断结果集是否有数据
            if (resultSet.next()) {
                // 获取当前数据的各字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    public static Customer queryForCustomers(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                Customer customer = new Customer();
                // 处理结果集一行数据的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i+1);

                    // 获取每个列的列名
                    String columnName = rsmd.getColumnName(i+1);
                    // 给某个属性赋值为value
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer, columnValue);
                }
                return customer;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    public static void main(String[] args) {
        String sql_query = "SELECT id, name, email, birth FROM customers c WHERE id = ?";
        Customer customer = queryForCustomers(sql_query, 5);
        System.out.println(customer);
    }
}
