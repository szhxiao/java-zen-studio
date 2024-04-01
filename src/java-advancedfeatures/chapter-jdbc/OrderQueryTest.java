/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDate;

/**
 * 
 */
public class OrderQueryTest {

    /**
     * 普通查询操作
     */
    public static void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql_query = "SELECT * FROM `order` o WHERE order_id = ?";
            ps = conn.prepareStatement(sql_query);
            ps.setObject(1, 1);

            rs = ps.executeQuery();

            if (rs.next()) {
                int id = (int) rs.getObject(1);
                String name = (String) rs.getObject(2);
//                LocalDate date = ((Date) rs.getObject(3)).toLocalDate();
                Date date = (Date) rs.getObject(3);

                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }

    public static Order orderForQuery(String sql, Object...args) {
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
                Order order = new Order();
                // 处理一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i+1);
                    // 获取列名，不推荐使用
                    // String columnName = rsmd.getColumnName(i+1);
                    // 获取列别名
                    String columnLabel = rsmd.getColumnLabel(i+1);

                    // 每个属性赋值
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
//                    if (columnLabel.equals("date")) {
//                        field.set(order, ((Date)columnValue).toLocalDate());
//                    } else {
//                        field.set(order, columnValue);
//                    }
                    field.set(order, columnValue);

                }
                return order;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
    
    public static void main(String[] args) {
//        testQuery();
        String sql_query = "SELECT order_id id, order_name name, order_date date FROM `order` o WHERE order_id = ?";
        Order order = orderForQuery(sql_query, 1);
        System.out.println(order);
    }

}
