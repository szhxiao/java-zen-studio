/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据批量操作
 */
public class InsertTest {

    /**
     * 批量插入方式一
     */
    public static void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();

            conn = JDBCUtils.getConnection();
            String sqlInsert = "INSERT INTO goods (name) VALUES (?)";
            ps = conn.prepareStatement(sqlInsert);

            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i);
                ps.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("花费时间为：" + (end - start)/1000 + "s");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }


    /**
     * 批量插入方式二
     * 1. addBatch(), executeBatch(), clearBatch()
     * 2. mysql开启批处理支持，配置文件url后添加?rewriteBatchedStatements=true
     */
    public static void testInsert2() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();

            conn = JDBCUtils.getConnection();
            String sqlInsert = "INSERT INTO goods (name) VALUES (?)";
            ps = conn.prepareStatement(sqlInsert);

            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i);

                // 1. 攒sql
                ps.addBatch();

                if (i % 500 == 0) {
                    // 2. 执行batch
                    ps.executeBatch();

                    // 3. 清空batch
                    ps.clearBatch();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("花费时间为：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    /**
     * 批量插入方式三
     * 设置不允许自动提交数据
     */
    public static void testInsert3() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            long start = System.currentTimeMillis();

            conn = JDBCUtils.getConnection();
            // 设置不允许自动提交
            conn.setAutoCommit(false);

            String sqlInsert = "INSERT INTO goods (name) VALUES (?)";
            ps = conn.prepareStatement(sqlInsert);

            for (int i = 0; i < 20000; i++) {
                ps.setObject(1, "name_" + i);

                // 1. 攒sql
                ps.addBatch();

                if (i % 500 == 0) {
                    // 2. 执行batch
                    ps.executeBatch();

                    // 3. 清空batch
                    ps.clearBatch();
                }
            }

            // 提交数据
            conn.commit();

            long end = System.currentTimeMillis();
            System.out.println("花费时间为：" + (end - start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }
    
    public static void main(String[] args) {
//        testInsert1();
//        花费时间为：202s

//        testInsert2();
//        花费时间为：1736ms

        testInsert3();
//        花费时间为：1147ms
    }    
}
